const { isValidPassword } = require("./password");
describe("password", () => {
  test("valid password", () => {
    const result = isValidPassword("abcdefgH12!");
    expect(result).toEqual({
      valid: true,
      reason: "",
    });
  });
  test("uppercase letter fail", () => {
    const result = isValidPassword("abcdefg12!");
    expect(result).toEqual({
      valid: false,
      reason: "Must contain an uppercase letter",
    });
  });
  test("no numbers fail", () => {
    const result = isValidPassword("abcdefghij");
    expect(result).toEqual({
      valid: false,
      reason: "Must contain a number",
    });
  });
  test("too short password", () => {
    const result = isValidPassword("Abc1");
    expect(result).toEqual({
      valid: false,
      reason: "Too short (min 8 characters)",
    });
  });
  test("non-string input", () => {
    const result = isValidPassword(12345);
    expect(result).toEqual({
      valid: false,
      reason: "Password must be a string",
    });
  });
});
