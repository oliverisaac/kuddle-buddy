import { Kubectl } from "../src/index"

test("should return the args we submit", () => {
    const args : String[] = [ "-n", "example"]
    const response = Kubectl.parseFlags(args);

    expect(response).toBe(args)
});
  
  