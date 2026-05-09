//////////////////// Question 1 ////////////////////////
// 1.
// var y;
// console.log(y); //Expected undefined bec it's declared but not initialized

// 2.
// console.log(x); //Expected Error! (not defined) bec x is not even declared

//3.
// var x = 10;
// var y = 20;
// console.log(y * x - 2); //evaluation from left to right so 10 * 20 = 200 - 2  = 198

//4.
// var y;
// console.log(typeof y); //expected undefined cause its declared without initalization
{
}
//5.
// var x = "1";
// var y = 2;
// console.log(x + y); //type cohertion will appear here as we are trying to add different dt so it will concat (12)

//6.
// var x = 1;
// var y = true;
// console.log(x + y); //type cohertion will also work here true will be evaluated to 1 so 1+1 will result into 2

//////////////////// Question 2 ////////////////////////
//Ask the user to enter a message then display it using the different html heading tags (
// from <h1> to <h6>) using Loops. DO NOT write the header element explicitly in your script!

// var i = 1;
// var res = prompt("Enter a message:");

// do {
//   document.write(`<h${i}>${res}</h${i}><br>`);
//   i++;
// } while (res && i <= 6);

//////////////////// Question 3 ////////////////////////

//Write a script that takes from the user n values and returns their sum,
//stop receiving values from user when he enters 0 or sum exceeds 100,
//check that the entered data is numeric and inform the user with the total sum of the entered values.

// var sum = 0;
// do {
//   var res = prompt("Enter a number");
//   if (!res || isNaN(res) || res == null) {
//     continue;
//   }
//   var num = Number(res);
//   if (num === 0) {
//     console.log(sum);
//     break;
//   }
//   sum += num;
//   console.log(sum);
// } while (sum < 100);

//////////////////// Question 4 ////////////////////////

// On contact page prompt user to enter his name, make sure that name is string,
//  and let the user enter his birth year and make sure that it is a number,
//  and it is less than 2010, and then calculate his age.
//  For each prompt if user input valid show him next prompt,
// if not valid show him the same prompt again until user enters it correctly (use loops).
//  And after validating user input, write all user input on the page in that format:
// Name: ahmed
// Birth year: 1981
// Age: 30

// Name input
var namee;
do {
  namee = prompt("Enter your name");
} while (!namee || !isNaN(namee));
var birthYear;
do {
  birthYear = Number(prompt("Enter your birth year"));
} while (!birthYear || !isFinite(birthYear) || birthYear >= 2010);
var age = 2026 - birthYear;
console.log("Name: " + namee);
console.log("Birth year: " + birthYear);
console.log("Age: " + age);

// do {
//   var res = prompt("Enter your name");
//   if (!res || !isNaN(res)) continue;
//   var birthYear = prompt("Enter your birth year");
//   birthYear = Number(birthYear);
//   if (birthYear || !isFinite(birthYear) || birthYear >= 2010) {
//     console.log(res + "\n");
//     console.log(birthYear + "\n");
//     console.log(2025 - birthYear);
//     break;
//   }
// } while (true);
