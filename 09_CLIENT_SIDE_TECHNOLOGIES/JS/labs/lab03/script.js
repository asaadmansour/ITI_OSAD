// ## Labs

// 1. **(Validation Lab)**
//    - prompt ask the user about number of persons
//    - enter the first username, enter the user age
//    - then print the info in a table

// 2. **(DOM Manipulation Lab)**
//    - make a list in the middle
//    - duplicate the image and move copies to top, right, bottom, left

// 3. **(Array Sort Lab)**
//    - take input from user
//    - use `array.sort()` with a callback function
//    - then insert the sorted result into the DOM

//1.

var table = document.getElementById("table1");
// console.log(table);
table.style.display = "none";
// var numberOfPersons;
// do {
//   numberOfPersons = prompt("Enter number of persons: ");
// } while (!numberOfPersons || !isFinite(numberOfPersons));
// var namesArr = [];
// var ageArr = [];
// var userName;
// var age;
// for (var i = 0; i < numberOfPersons; i++) {
//   do {
//     userName = prompt(`Enter the name of person ${i + 1} `);
//   } while (!userName || !isNaN(userName));
//   do {
//     userAge = prompt(`Enter the age of person ${i + 1} `);
//   } while (!userAge || !isFinite(userAge));
//   namesArr.push(userName);
//   ageArr.push(userAge);
//   console.log(namesArr);
//   console.log(ageArr);
// }
// table.style.display = "table";
// for (var i = 0; i < namesArr.length; i++) {
//   table.innerHTML += `<tr><td>${namesArr[i]}</td><td>${ageArr[i]}</td></tr>`;
// }

// 3.

// var array = [];
// var num;

// for (var i = 0; i < 5; i++) {
//   do {
//     num = prompt(`Enter the value of number ${i + 1}`);
//   } while (!num || !isFinite(num));
//   array.push(num);
// }
// var h2 = document.createElement("h2");
// var br = document.createElement("br");
// var p = document.createElement("p");
// var p2 = p.cloneNode(false);
// var p3 = p.cloneNode(false);
// h2.textContent = "Sorting";
// p.textContent = "u've entered the values of ";
// p2.textContent = "ur values after being sorting ascending ";
// p3.textContent = "ur values after being sorting descending ";
// array.forEach((e) => (p.textContent += ` ${e}`));
// function myFuncAsc(a, b) {
//   return a - b;
// }
// function myFuncDesc(a, b) {
//   return b - a;
// }
// array.sort(myFuncAsc);
// array.forEach((e) => (p2.textContent += ` ${e}`));
// array.sort(myFuncDesc);
// array.forEach((e) => (p3.textContent += ` ${e}`));

// var body = document.body;
// body.append(h2);
// body.append(br);
// body.append(p);
// body.append(p2);
// body.append(p3);
// console.log(array);
