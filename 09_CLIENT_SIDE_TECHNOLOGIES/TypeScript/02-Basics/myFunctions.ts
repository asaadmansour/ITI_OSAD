// function addTwo(num) {
//   return num + 2;
// } // bad
// we should always define our parameter data type
// also we don't get any suggestions if we didnt define a type for our value
function addTwo2(num: number) {
  return num + 2;
}
function getUpper(val: string) {
  return val.toUpperCase();
}
// to do default parameters to be able to call the fn with less arguments we do beside the dt = xxx
let userLogin = (name: string, email: string, isPremium: boolean = false) => {};
userLogin("asaad", "asaad", true);
userLogin("asaad", "asaad");
// both works!!

// we also need to specify the return type to make sure that we got the expected type from the fn
function getUpper2(val: string): string {
  // return false; here we will get error bec we the expexted returned value is string not boolean
  return val.toUpperCase();
}
// we may need to return different types from the fn and here we use what is called union types which we will discuss later on
const heros = ["BROTHER", "MOM", "DAD"];
heros.map((hero): string => {
  return "hero " + hero;
});
// we should also declare void explictly when we need to
function consoleError(errMsg: string): void {
  console.log(errMsg);
}
// we should use never as a return type when we dealing with errors
function handleError(errMsg: string): never {
  throw new Error(errMsg);
}
export {};
