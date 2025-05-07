package main

import (
	"log"
	"os"
	"os/exec"
	"strings"

	"github.com/pkg/errors"
)

func main() {
	kuddleArgs := applyTweaksToArgs(os.Args[1:])

	exitCode, err := runAttachedCommand("kubectl", kuddleArgs...)
	if err != nil {
		log.Fatal(errors.Wrap(err, "Failed to run the command"))
		os.Exit(1)
	}
	os.Exit(exitCode)
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
