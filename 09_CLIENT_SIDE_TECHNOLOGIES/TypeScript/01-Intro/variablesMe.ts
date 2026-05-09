let greeting: string = "Hello world!";
console.log(greeting);
// type sctipt offer static checking and type safety so we use it in parameters returns etc
let fixed: boolean = false;
// typescript autodetects the type so i don't have to over use types in my code
let myNumber: number = 6; // bad practice
let myNumber2 = 6; //  this is better cause typescript auto detect the type so we shouldn't use types in obvious cases
// and we still even get the correct object methods for the correct dt we have, and we still get the error if we assigned different
// dt to the defined variable above like myNumber2  "asaad"

// any

let hero;
function getHero() {
  return "thor";
  //   now even if we did return true it wouldnt complain so we shouldn't do that
}
hero = getHero();
// we shouldn't use any in normal basis cause why did we switch to ts in the first case
// any is used like a gateway or like turning off type checking which is not good but ts use it when it got no type
// and to avoid falling inn such a mistake u should enable noImplicitAny
function getHero2() {
  return "thor";
  //   now even if we did return true it wouldnt complain so we shouldn't do that
}
export {};
