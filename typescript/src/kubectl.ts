export class Kubectl {
    static parseFlags(args:String[]) : String[] { 
        var doneParsing:Boolean = false
        const mappers:Map<String,String> = new Map()
                .set("-x", "--context")

        var foundMappers:Map<String,Boolean> = new Map()

        const ret:String[] = args.map( function(arg:String):String {
            if (arg == "--" || doneParsing) {
                doneParsing = true
                return arg
            } else if (mappers.get(arg) !== undefined && foundMappers.get(arg) !== true) {
                foundMappers.set(arg, true)
                return mappers.get(arg) as String
            } 

            return arg
        })

        return ret
    }
}