import { Kubectl } from "../src/kubectl"

test("should return the args we submit", () => {
    const args : String[] = [ "-n", "example"]
    const response = Kubectl.parseFlags(args);

    expect(response).toStrictEqual(args)
});
  
test("should set -x to --context", () => {
    let args : String[] = [ "-x", "example", "--", "-x", "hello"]
    let response = Kubectl.parseFlags(args);

    let expected : String[] = args.slice()
    expected[0] = "--context"

    expect(response).toStrictEqual(expected)
});
  
test("should not modify args after a double dash", () => {
    const args : String[] = [ "-n", "example", "--", "-x", "hello"]
    const response = Kubectl.parseFlags(args);

    expect(response).toStrictEqual(args)
});
  
test("should not modify args more than once", () => {
    const args : String[] = [ "-x", "example", "-x", "hello"]
    const response = Kubectl.parseFlags(args);

    let expected : String[] = args.slice()
    expected[0] = "--context"

    expect(response).toStrictEqual(expected)
});
  