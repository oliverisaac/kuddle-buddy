import { ChildProcess, exec, ExecException } from "child_process"
import shellescape = require("shell-escape")

export class CommandOutput {
    _stdout: string[]
    _stderr: string[]
    error: ExecException | null

    constructor(){
        this._stdout = []
        this._stderr = []
        this.error = null
    }

    public get stdout():string{
        return this._stdout.join("\n")
    }
    appendStdout(line:string):CommandOutput {
        this._stdout.push(line)
        return this
    }

    public get stderr():string{
        return this._stderr.join("\n")
    }
    appendStderr(line:string):CommandOutput {
        this._stderr.push(line)
        return this
    }

    setError(err:ExecException|null):CommandOutput {
        this.error = err
        return this
    }

    static fromError(error:string|Error):CommandOutput {
        if (error instanceof Error ) {
            return new CommandOutput().appendStderr(error.message).setError(error)
        } else {
            return new CommandOutput().appendStderr(error).setError(new Error(error))
        }
    }
}

export function runCommand(command: string[]): Promise<CommandOutput> {
    return new Promise<CommandOutput>((resolve) => {
        let output:CommandOutput = new CommandOutput()

        let process:ChildProcess = exec(shellescape(command), (error, stdout, stderr) => {
            output.appendStdout(stdout)
            output.appendStderr(stderr)

            if (error) {
                output.setError(error)
                resolve(output)
            } else {
                resolve(output)
            }
        })
    });
}
export class Kuddle {
    static parseFlags(args:string[]) : string[] { 
        var doneParsing:Boolean = false
        const mappers:Map<string,string> = new Map()
                .set("-x", "--context")

        var foundMappers:Map<string,Boolean> = new Map()

        const ret:string[] = args.map( function(arg:string):string {
            if (arg == "--" || doneParsing) {
                doneParsing = true
                return arg
            } else if (mappers.get(arg) !== undefined && foundMappers.get(arg) !== true) {
                foundMappers.set(arg, true)
                return mappers.get(arg) as string
            } 

            return arg
        })

        return ret
    }

    static async run(args:string[]):Promise<CommandOutput>{
        if (args[0] == "containers" ){
            return new Promise<CommandOutput>((resolve, reject)=> {
                reject(CommandOutput.fromError("Containers not impl"))
            })
        } else {
            return runCommand(["kubectl", ...this.parseFlags(args)])
        }
    }
}
