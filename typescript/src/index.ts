import { CommandOutput, Kuddle } from "./kubectl";

Kuddle.run(process.argv.slice(2)).then( result => {
    process.stderr.write(result.stderr)
    process.stdout.write(result.stdout)
}).catch( result => {
    if (result instanceof CommandOutput) {
        process.stderr.write(result.stderr + "\n")
        process.stdout.write(result.stdout + "\n")
        process.exit(1)
    } else {
        throw(result)
    }
})
