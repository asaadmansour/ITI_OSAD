///////////// Question 1 ////////////

// var userName;
// do {
//   userName = prompt("Enter your name: ");
// } while (!userName || !isNaN(userName));
// var phoneNumber;
// do {
//   phoneNumber = prompt("Enter your phone number: ");
// } while (!phoneNumber || !isFinite(phoneNumber) || phoneNumber.length < 8);
// var mobileNumber;
// do {
//   mobileNumber = prompt("Enter your mobile number: ");
// } while (
//   !mobileNumber ||
//   !isFinite(mobileNumber) ||
//   mobileNumber.length < 11 ||
//   (!mobileNumber.startsWith("010") &&
//     !mobileNumber.startsWith("011") &&
//     !mobileNumber.startsWith("012"))
// );
// var email;
// var emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
// do {
//   email = prompt("Enter your email: ");
// } while (!email || !email.match(emailRegex));

///////////// Question 2 ////////////

// var word;
// do {
//   word = prompt("Enter the word to check");
// } while (!word || !isNaN(word));

// var caseSensitve;
// do {
//   caseSensitve = prompt(
//     "should we consider case senstivity in check if the word is palindrome?"
//   );
// } while (
//   !caseSensitve ||
//   (caseSensitve.toLowerCase() != "yes" && caseSensitve.toLowerCase() != "no") ||
//   !isNaN(caseSensitve)
// );

// if (caseSensitve.toLowerCase() == "yes") {
//   isPalindrome(word);
// } else if (caseSensitve.toLowerCase() == "no") {
//   var wordNoCaseSenstive = word.toLowerCase();
//   isPalindrome(wordNoCaseSenstive);
// }
// // use reverse /join / split
// function isPalindrome(word) {
//   var left = 0,
//     right = word.length - 1;
//   while (left < right) {
//     if (word[left] != word[right]) {
//       console.log("Not palindrome");
//       return;
//     }
//     left++;
//     right--;
//   }
//   console.log("palindrome");
// }

///////////// Question 3 ////////////

// var radius;
// radius = prompt("Enter a radius");
// var radiusNumber = parseFloat(radius);
// console.log(calcArea(radiusNumber));
// function calcArea(radius) {
//     return Math.trunc(Math.PI * Math.pow(radius,2));
// }

// var number;
// number = prompt("Enter a number");
// var numberNumber = parseFloat(number);
// console.log(calcSquareRoot(numberNumber));
// function calcSquareRoot(number) {
//     return Math.sqrt(number);
// }
// console.log(calcSquareRoot(16));

///////////// Question 4 ////////////

// var arr = [];

// for (var i = 0; i < 3; i++) {
//   arr[i] = Number(prompt(`Enter number ${i + 1}`));
// }
// var sum = 0;
// var product = 1;
// var division = arr[0];
// for (var i = 0; i < 3; i++) {
//   sum += arr[i];
//   product *= arr[i];
//   if (i > 0) division /= arr[i];
// }
// console.log("sum of " + arr.join(" + ") + " is equal: " + sum);
// console.log("product of " + arr.join(" x ") + " is equal: " + product);
// console.log("division of " + arr.join(" / ") + " is equal: " + division);

///////////// Question 5 ////////////

//1.

// function myfunction(x, y) {
//   if (arguments.length != 2)
//     throw new Error("Numbers of parameters less than or exceed 2!");
// }
// myfunction(2, 2);

//2.

var arr = [];
function myfunction() {
  //   for (var i = 0; i < arguments.length; i++) {
  //     arr.push(arguments[i]);
  //   }
  //   return arr.reverse();
  // or
  //   return Array.from(arguments).reverse();
}
// console.log(myfunction("asaad", "ahmed", "omar", "karim"));

//3.

// var sum = 0;

// function myfunction() {
//   for (var i = 0; i < arguments.length; i++) {
//     if (isFinite(arguments[i])) sum += arguments[i];
//     else throw new Error("not a number");
//   }
//   return sum;
// }
// console.log(myfunction(1, 2, 3, 4, 5, "assad", 20, 5));

//4.

// function myfunction(date) {
//   var date = new Date(date);
//   var dayNumber = date.getDay();
//   switch (dayNumber) {
//     case 0:
//       return "Sunday";
//     case 1:
//       return "Monday";
//     case 2:
//       return "Tuesday";
//     case 3:
//       return "Wednesday";
//     case 4:
//       return "Thursday";
//     case 5:
//       return "Friday";
//     case 6:
//       return "Saturday";
//   }
// }
// console.log(myfunction("1/5/2026"));
