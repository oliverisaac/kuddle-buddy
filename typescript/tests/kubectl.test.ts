import { CommandOutput, Kuddle, runCommand } from "../src/kubectl"

test("should return the args we submit", () => {
    const args : string[] = [ "-n", "example"]
    const response = Kuddle.parseFlags(args);

    expect(response).toStrictEqual(args)
});
  
test("should set -x to --context", () => {
    let args : string[] = [ "-x", "example", "--", "-x", "hello"]
    let response = Kuddle.parseFlags(args);

    let expected : string[] = args.slice()
    expected[0] = "--context"

    expect(response).toStrictEqual(expected)
});
  
test("should not modify args after a double dash", () => {
    const args : string[] = [ "-n", "example", "--", "-x", "hello"]
    const response = Kuddle.parseFlags(args);

    expect(response).toStrictEqual(args)
});
  
test("should not modify args more than once", () => {
    const args : string[] = [ "-x", "example", "-x", "hello"]
    const response = Kuddle.parseFlags(args);

    let expected : string[] = args.slice()
    expected[0] = "--context"

    expect(response).toStrictEqual(expected)
});

test("runCommand should return every line of output", async ()=>{
    const commandResult = await runCommand([
        "bash", "-c", "printf '%s\n' a b"
    ])
    expect(commandResult.stdout).toEqual("a\nb\n")
});

test("kubectl run should return the output", async () => {
    let result = await Kuddle.run(["help"])
    expect(result.stdout).toContain("kubectl controls the Kubernetes cluster manager")
});

test("kubectl version should return the client version", async() => {
    let result = await Kuddle.run(["version"])
    expect(result.stdout).toContain("Client Version")
});
  
test("kubectl with -x should not cause an error", async() => {
    let result:CommandOutput = await Kuddle.run(["version", "-x", "woierjewori"])
    expect(result.stderr).not.toContain("Error: unknown shorthand flag: 'x'")
    expect(result.stderr).toContain(`error: context "woierjewori" does not exist`)
});
