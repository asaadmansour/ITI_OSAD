### JS

---

## What is JavaScript?

js is a scripting dynamic programming language (interpreted)

**scripting language vs programming language vs markup language**

- programming languages are mostly compiled and result in binary executable file
- scripting languages are interpreted which means they work line by line
- markup languages give a layout and structure to the document

with js we can make the document(html) dynamic, we can also validate the forms and handle user events based on actions, we can also animate and control the screen that displays the website

---

## JavaScript Runtime Environment

browser is a host environment and it hosts the javascript runtime
javascript has the normal programming language features defined by the language itself, but extra features are added depending on the environment it runs in

browsers are the client and a primary runtime environment for client-side JavaScript. JavaScript is not inherently browser-dependent; only browser-specific APIs make code browser-dependent.

in the browser environment, the browser provides objects and apis like `document` which represents and manipulates the html through the DOM
it also provides the browser object model (BOM) mainly through the `window` object, which gives access to things like `navigator`, `screen`, `location`, `history`, and `frames`
most of these objects and apis are exposed globally through the `window` object, since window is the global object in the browser
other web apis like `XMLHttpRequest` are also provided by the browser environment and are not part of the javascript language itself

---

## The \<script\> Tag

`<script></script>` can be written in the head or at the end of the body, it works both ways but if the script code is dependent on html tags then it should be at the end after the whole html is declared

---

## Data Types

### Primitive Data Types

primitive data types -> non object types that are defined directly in the stack which is faster and more efficient

- **string**
- **number**
- **boolean**
- **null** - when it's empty like initialized with null
- **undefined** - when it's uninitialized, so if we have the variable and we use it, it's undefined. but if the variable itself is not defined we get an error! (not a data type, and "not defined" is not the same as "undefined"!)

it's a dynamic language so we can do `var age = 10;` then `age = "asaad";`

### typeof()

`typeof()` to get the type of the variable, it returns a string that describes the type like `"number"`

- if null it returns `"object"` (this is a known bug in js)
- undefined returns `"undefined"`

---

## Type Coercion

js has type coercion so if we did string + number it will convert the number in this operation temporarily to string and concatenate

- `true + number` will make true as 1
- `x + undefined` returns `NaN` (Not a Number)
- `NaN` -> when we do an illogical calculation then js returns NaN, and its type is still `"number"`

**rules with + operator:**

- if there is one string on any side of + it will concatenate
- any arithmetic operation on strings except + will return NaN

**rules with - operator:**

- if the values can be coerced into numbers it will convert them into numbers

**example:**
`(3<2<1)` will return true because: `3<2` is false, then `false < 1` evaluates to `0 < 1` which is true

⚠️ type coercion kicks in when we write bad code or don't check types, so try to prevent it as much as possible

---

## Comparison Operators

`==` checks the value without the type, to check both type and value we use `===`

---

## Control Statements

**if/else:**

```js
if (condition) {
  // code
} else {
  // code
}
```

the condition evaluates based on whether the value is truthy or falsy

**falsy values:** `null`, `""` (empty strings), `undefined`, `NaN`, `false`, `0`, `-0`
all other values are truthy

---

## Loops

**for loop:**

```js
for (var i = start; i < condition; i++) {
  // looped code
}
```

**do while loop:**

```js
do {
  // code
} while (condition);
// executes code once first, then loops while condition is true
```

**while loop:**

```js
while (condition) {
  // code
}
```

---

## Switch Statement

```js
switch (expression) {
  case 1: // if expression == 1
    console.log("one");
    break; // break is needed to stop execution
  default: // runs if no case matches
    console.log("default");
}
```

---

## Variable Scoping (var)

⚠️ `var` has function scope, not block scope. this means if we define a variable with `var` inside curly brackets (like in `for` or `if`), it's still accessible globally - we can use it anywhere and even redefine it. this was the behavior before ES6 introduced `let` and `const` which have proper block scoping

---

## Browser Methods

- `alert("message")` -> shows a message to the user but it blocks the execution and its design depends mainly on the browser
- `document.write('<h1 style="background-color:red">hello</h1>')` -> writes directly into the document and styles it
- `confirm("message")` -> shows a message with OK/Cancel buttons, OK returns `true`, Cancel returns `false`
- `prompt("message")` -> takes input from user, returns the input as a string, Cancel returns `null`, if input is empty it returns `""`

---

## Built-in Functions

- `eval("expression")` -> evaluates the expression and returns the value
  ```js
  eval("2 + 2"); // returns 4
  eval("x = 10"); // assigns 10 to x
  ```
- `isFinite(value)` -> checks if the value can be converted to a finite number and returns true. empty string, null, and other falsy values can be converted to a number so they return true
- `isNaN(value)` -> checks if value is Not a Number
- `Number(value)` -> converts any value to a Number
- `parseInt(value)` -> converts the value to integer
- `parseFloat(value)` -> converts the value to float

---

## Built-in Objects

classes in other languages are called **function constructors** in JS

- **Object** -> parent object that all inherits from
- **Math** -> Math is a Static class (eg. Math.methods);
- **String**
- **Boolean**
- **Array**
- **Date**
- **Number**

### Wrapper Objects

**the problem:**

- objects/classes have properties and methods but are less performance efficient
- primitives are faster but don't have methods and properties

**the solution:**
wrapper objects! when we write a primitive normally it stays as a primitive (fast), but when we use `.` notation to access a method/property, JavaScript temporarily wraps it in an object

**how wrapper objects work:**

```js
let str = "hello";
let upper = str.toUpperCase();

// Behind the scenes:
// 1. temp = new String("hello");     // Creates temporary wrapper object
// 2. result = temp.toUpperCase();    // Calls method on wrapper, returns NEW value "HELLO"
// 3. temp is destroyed               // Wrapper is discarded immediately
// 4. upper = result;                 // The returned value is assigned
// 5. str is STILL "hello"            // Original primitive never changed!
```

**primitives are immutable:**
wrapper methods return a NEW value, they don't modify the original primitive

**how to use the returned value:**

```js
// ❌ Wrong - value is lost:
str.toUpperCase(); // Returns "HELLO" but we throw it away

// ✅ Correct - use it in an expression:
console.log(str.toUpperCase()); // Returns "HELLO" to console.log()
let result = str.toUpperCase(); // Returns "HELLO" to the variable
alert(str.toUpperCase()); // Returns "HELLO" to alert()
```

---

## Host Objects

objects that are provided by the hosting environment (the browser)

- **BOM** (Browser Object Model)
- **DOM** (Document Object Model)

---

## Regular Expressions

**why it's used:**
it's used to validate data in a simpler way than if/else statements

**how to create:**

```js
var regex = new RegExp("expression");
var reg = /expression/; // literal notation
// both ways work, literal notation always starts with / and ends with /
```

**methods:**

it's still an object so it has methods

- `test()` -> returns boolean, checks if the input matches the expression

---

## Array

**how to create:**

```js
var arr = new Array();
var arr = []; // preferred way
```

**characteristics:**

- it's flexible/dynamic - can store different types
- has multiple built-in methods

**important notes:**

⚠️ don't set elements at random indexes in the middle because js won't complain - it will create them and the gaps will be `empty`
use `.push()` instead! -> pushes at the end
`.unshift()` -> pushes at the beginning

if we try to get an element that doesn't exist in the array it returns `undefined`, not an error

**methods:**

- `reverse()` -> reverses the array **in place** (modifies original)
- `concat()` -> combines arrays
- `join()` -> joins array elements into a string

---

## Date Object

**how to create:**

```js
var d = new Date(); // creates date of current local machine time
var d = new Date(2026, 0, 12); // creates specific date (year, month, day)
```

**important notes:**

⚠️ months are 0-indexed (January = 0, February = 1, etc.)
time values are also 0-indexed

**methods:**

- `d.getDay()` -> gets day of week
- `d.getYear()` -> gets year
- `d.getMonth()` -> gets month

**date format types:** ISO / short / long / full

---

## Functions

### How to Create Functions

**1. Function Declaration (statement):**

```js
function myFunction() {
  // function body
}
```

**2. Function Expression:**

```js
var x = function() {
  // function body
};
// x is a reference to the function
```

**3. Function Constructor (old way, not recommended):**

```js
var x = new Function();
```

### Invoking Functions

```js
myFunc(); // function calling with ()
console.log(myFunc); // prints the function body itself (without calling)
```

### Default Return Value

if we don't return anything, functions in js always return `undefined`

even if we save `console.log()` in a variable and then try to print it, we will see `undefined`

```js
var result = console.log("hello"); // prints "hello"
console.log(result); // undefined
```

we can override this by explicitly returning a value

---

### Function Scope

⚠️ **functions are the only thing that hide variables** (create their own scope)

**local scope:**

```js
function myfn() {
  var x = 10;
  console.log(x); // 10
}
console.log(x); // error! x is not defined
```

**shadowing (local variable hides global):**

```js
var x = 20; // global
function myfn() {
  var x = 10; // local, shadows the global
  console.log(x); // 10 (uses local)
}
myfn();
console.log(x); // 20 (uses global)
```

**forgetting `var` creates global variables:**

```js
function myfn() {
  x = 10; // no 'var', so x becomes GLOBAL!
  console.log(x); // 10
}
myfn();
console.log(x); // 10 (x is now global)
```

⚠️ always use `var` inside functions to avoid accidentally creating globals!

**functions are only checked when called:**

if we don't call the function and try to access a variable inside it, we get `undefined` - js doesn't check the function body until it's invoked

---

### Making Functions Stricter

**type checking:**

```js
function sum(x, y) {
  if (typeof x != "number" || typeof y != "number") {
    throw new Error("function only accepts numbers");
  }
  return x + y;
}
```

**checking number of arguments:**

we can check the number of arguments passed using the `arguments` object (array-like iterator)

```js
function sum(x, y) {
  if (typeof x != "number" || typeof y != "number") {
    throw new Error("function only accepts numbers");
  }
  if (arguments.length !== 2) {
    throw new Error("expected 2 arguments, got " + arguments.length);
  }
  return x + y;
}
```

**using arguments for variable number of parameters:**

we can use `arguments` to accept any number of arguments without specifying parameters

```js
function sum() {
  var total = 0;
  for (var i = 0; i < arguments.length; i++) {
    total += arguments[i];
  }
  return total;
}

sum(1, 2, 3); // 6
sum(1, 2, 3, 4, 5); // 15
```

---

## Hoisting

```js
console.log(x);
var x = 10;
```

here we're trying to access x before it's defined, so it should throw a reference error (not defined), how does it work???

the hoisting - js does a cool thing: the engine goes through the whole code and sees if there are any var declarations and function statements and moves them to the very beginning of the code. so when it goes to the execution process it already knows the variables and we can also call the function before its body. so it's `undefined` instead of reference error

**function statements** will work as they will be hoisted as complete functions

**but function expressions/arrow functions** are hoisted as variables, so calling them before definition will lead to a TypeError (not a function), because the variable is `undefined`

```js
// Function Declaration - ✅ works
myFunc(); // works!
function myFunc() {
  console.log("hello");
}

// Function Expression - ❌ TypeError
myFunc2(); // TypeError: myFunc2 is not a function
var myFunc2 = function() {
  console.log("hello");
};
```


---

## Lexical Scope

functions are like variables in js, so if we have a function declared and it has another function inside it, even though the inner function is hoisted, it cannot be accessed from outside the parent function scope (just like a variable)

however, the child function CAN see the parent function's variables

```js
function parent() {
  var x = 10;
  function child() {
    console.log(x); // ✅ can access parent's variable
  }
  child();
}
parent();
// child(); // ❌ error! child is not defined outside parent
```

---

## let vs var

how is `let` created/works?

`let` is basically a `var` that is wrapped inside a function (usually a self-invoked function) and then called immediately, so it hides the variables

```js
// var - function scoped
for (var i = 0; i < 3; i++) {
  // i is accessible outside
}
console.log(i); // 3 ✅ works

// let - block scoped  
for (let j = 0; j < 3; j++) {
  // j is only accessible inside
}
console.log(j); // ❌ error! j is not defined
```

---

## Callback Functions

functions can take another function as a parameter because functions always return something (even if `undefined`), so it's not a problem to pass it as a parameter

**two ways to pass functions:**

1. pass the function reference (just the name, no parentheses)
2. pass the function's return value (with parentheses)

```js
function sum(fn1, fn2) {
  return fn1() + fn2(); // call the functions inside
}

function getOne() {
  return 1;
}

function getTwo() {
  return 2;
}

sum(getOne, getTwo); // pass references, returns 3
```

---

## forEach and the arguments Pattern

**how forEach works:**

it always sends three things in this order: `element`, `index`, `array`

```js
function test(el, i, arr) {
  console.log(arguments); // [element, index, array]
}

var array = [1, 2, 3, 4];
array.forEach(test);
```

**how forEach is implemented behind the scenes:**

```js
function foreach(array, fn) {
  for (var i = 0; i < array.length; i++) {
    fn(array[i], i, array); // element, index, array
  }
}
```

**example - summing array elements:**

```js
var sum = 0;
function addToSum(el, i, arr) {
  sum += el;
  console.log(sum);
}

var array = [1, 2, 3, 4];
array.forEach(addToSum); // sum becomes 10
```

---

## DOM/BOM

### BOM (Browser Object Model)

we have these because of the front-end environment

browser is hosting the js, browser has a big object named `window` object which offers us & js some methods to use

anything inside the `window` can be accessed directly without writing `window.` because window is the global object, so its methods can be accessed directly

global variables are inserted into the window object, so we can do `console.log(window.myVar)`

### DOM (Document Object Model)

we access the DOM through `window.document` - document refers to the HTML (and why window? because the HTML at the end runs in the browser)

HTML has a root - it's the `document` object which allows us to access and edit:
- elements
- attributes
- styles
- events

**HTML DOM Nodes:**

- document itself is a node
- all HTML elements are element nodes
- attributes are attribute nodes
- text inside elements are text nodes

js sees the DOM as a tree:

```
       document
          |
        html
       /    \
    head    body
      |
    title
      |
   "test"
```

once we reach an element, we can reach its parent, children, siblings, etc.

---

### DOM Navigation

```js
document.children // -> [html]
document.children[0].firstElementChild // -> head
document.children[0].lastElementChild // -> body

body.children // returns HTML collection (only tags)
body.childNodes // returns ALL nodes (comments, empty spaces, content, etc.)
```

⚠️ in general: `elements` return collections (tags only), but `nodes` return everything (including text, comments, whitespace)

---

### Element Selection (shortcuts)

```js
document.getElementsByTagName("div") // returns array-like [div, div]
document.getElementsByClassName("myclass") // returns [span, div] with that class
// to select one: div[0].something

document.getElementById("myId") // returns ONE element

document.querySelector(".myclass") // returns FIRST element matching CSS selector
document.querySelectorAll(".myclass") // returns collection of all matches
// by id, collection will have only one
```

---

### Element Manipulation

**attributes:**

```js
div.setAttribute("class", "myclass") // adds or updates attribute
```

**classes (for multiple classes):**

```js
div.classList.add("class1", "class2") // add multiple classes
div.classList.remove("class1") // remove class
div.classList.toggle("active") // toggle class on/off
```

⚠️ use `classList.add()` instead of `setAttribute("class")` to add multiple classes, because `setAttribute` will overwrite existing classes

**styles:**

```js
div.style.color = "red";
div.style.backgroundColor = "blue";
```

---

### Creating & Adding Elements

**changing existing content:**

```js
element.textContent = "new text" // changes text content
element.innerHTML = "<h2>hamada</h2>" // replaces HTML content
element.innerHTML += "<h2>more</h2>" // appends HTML content
```

**creating new elements:**

```js
var x = document.createElement("div"); // creates element (not in DOM yet)
x.style.color = "red"; // style it
x.textContent = "hello"; // add content

parentDiv.append(x); // NOW it's added to the DOM
```

**cloning elements:**

if we create an element and append it to both body and div, it will only appear in div because at the end it's a node with one reference and we just moved it

```js
var h3 = document.createElement("h3");
body.append(h3);
div.append(h3); // h3 moves from body to div!

// to make a real copy:
var clone = h3.cloneNode(true); // true = clone with all children
// false = clone without children

div.append(clone); // now both exist separately
```

---

## Labs

1. **(Validation Lab)**
   - prompt ask the user about number of persons
   - enter the first username, enter the user age
   - then print the info in a table

2. **(DOM Manipulation Lab)**
   - make a list in the middle
   - duplicate the image and move copies to top, right, bottom, left

3. **(Array Sort Lab)**
   - take input from user
   - use `array.sort()` with a callback function
   - then insert the sorted result into the DOM