package main

import (
	"fmt"
	"log"
	"os"
	"os/exec"
	"strings"

	"github.com/pkg/errors"
	"github.com/sirupsen/logrus"
	"github.com/spf13/pflag"
)

func main() {
	kuddleArgs := applyTweaksToArgs(os.Args[1:])

	var exitCode int
	var err error
	if commandOrSubcommand(os.Args, "kcontainers") {
		exitCode, err = kcontainers(kuddleArgs)
	} else {
		exitCode, err = runAttachedCommand("kubectl", kuddleArgs...)
	}
	if err != nil {
		log.Fatal(errors.Wrap(err, "Failed to run the command"))
		os.Exit(1)
	}
	os.Exit(exitCode)
}

func commandOrSubcommand(osArgs []string, needle string) bool {
	if osArgs[0] == needle {
		return true
	}
	if len(osArgs) > 1 && osArgs[1] == needle {
		return true
	}
	return false
}

func kcontainers(args []string) (int, error) {
	flags := pflag.NewFlagSet("kcontainers", pflag.ExitOnError)

	var context string
	flags.StringVarP(&context, "context", "c", "", "Context to get contianers in")

	var namespace string
	flags.StringVarP(&namespace, "namespace", "n", "", "Namespace to get contianers in")

	var allNamespaces bool
	flags.BoolVarP(&allNamespaces, "all-namespaces", "A", false, "Get containers in all namespaces")

	err := flags.Parse(args)
	if err != nil {
		return 1, errors.Wrap(err, "parsing flags")
	}

	logrus := logrus.WithFields(logrus.Fields{
		"context":        context,
		"namespace":      namespace,
		"all-namespaces": allNamespaces,
	})

	logrus.Info("Going to run kcontainers")

	return 0, fmt.Errorf("not impl")
}

// applyTweaksToArgs modifies the args sent in so they work wtih kubectl
// Goals:
// The -x flag should become --context
func applyTweaksToArgs(args []string) []string {
	replacedFlags := map[string]bool{}
	shortHandReplacements := map[string]string{
		"-x": "--context",
	}

	for i, arg := range args {
		if arg == "--" {
			break
		}
		for shorthand, longform := range shortHandReplacements {
			if strings.HasPrefix(arg, shorthand+"=") || arg == shorthand {
				if _, ok := replacedFlags[shorthand]; !ok {
					args[i] = strings.Replace(arg, shorthand, longform, 1)
					replacedFlags[shorthand] = true
				}
			}
		}
	}
	return args
}

func runAttachedCommand(command string, args ...string) (exitCode int, runErr error) {
	cmd := exec.Command(command, args...)
	cmd.Stdin = os.Stdin
	cmd.Stdout = os.Stdout
	cmd.Stderr = os.Stderr

	runErr = cmd.Run()
	exitCode = cmd.ProcessState.ExitCode()
	return exitCode, errors.Wrapf(runErr, "Failed to run command %q %q", command, args)
}
