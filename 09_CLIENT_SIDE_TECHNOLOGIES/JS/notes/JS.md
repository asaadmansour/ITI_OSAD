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

objects that are provided by the hosting environment (the browser) - see [DOM/BOM section](#dombom) for details

- **BOM** (Browser Object Model) → the `window` object
- **DOM** (Document Object Model) → the `document` object

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

**BOM and DOM are just concept names - the actual objects are `window` and `document`:**

| Concept (name) | Actual Object | What it represents |
|----------------|---------------|--------------------|
| **BOM** (Browser Object Model) | `window` | everything the browser provides |
| **DOM** (Document Object Model) | `document` | the HTML page structure |

### BOM = `window` object

the browser provides the `window` object which contains:

```
window (the BOM)
    ├── document (the DOM) ← the HTML page
    ├── navigator ← browser/device info (os, network, etc.)
    ├── location ← URL info
    ├── history ← browser history
    ├── screen ← screen dimensions
    ├── localStorage / sessionStorage
    ├── alert(), confirm(), prompt()
    ├── setTimeout(), setInterval()
    ├── open(), close(), print()
    └── ... all global stuff
```

`window` is the global object - anything inside it can be accessed directly without writing `window.`:

```js
window.document === document  // true
window.alert() === alert()    // true
```

global variables are inserted into window: `console.log(window.myVar)`

### DOM = `document` object

`document` is inside `window` and represents the HTML page. it allows us to access and edit:
- elements
- attributes
- styles
- events

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

**everything in the DOM is a Node:**

the DOM is a tree of nodes. there are different types of nodes:
- **Element nodes** → HTML tags (`<div>`, `<span>`, `<p>`) - the ones we work with most
- **Text nodes** → text content inside tags
- **Comment nodes** → `<!-- comments -->`
- **Document node** → the document itself

**collections are just different ways to store/group nodes:**

| Feature | HTMLCollection | NodeList |
|---------|----------------|----------|
| Contains | **Elements only** (HTML tags) | **Any node type** (elements, text, comments) |
| Live/Static | Always **live** (auto-updates) | Usually **static** (snapshot) |
| `forEach` | ❌ (convert to array first) | ✅ |
| Returned by | `getElementsBy*`, `children` | `querySelectorAll`, `childNodes` |

⚠️ exception: `childNodes` returns a **live** NodeList

think of it like: nodes are the items, collections are the containers that hold them

```js
document.children // -> [html]
document.children[0].firstElementChild // -> head
document.children[0].lastElementChild // -> body

body.children // returns HTMLCollection (only tags)
body.childNodes // returns NodeList with ALL nodes (comments, empty spaces, content, etc.)
```

**converting to array (to use array methods on either):**

```js
var arr1 = Array.from(htmlCollection);
var arr2 = [...nodeList];
```

```js
// example showing live vs static behavior:
var divs = document.getElementsByTagName("div"); // HTMLCollection (live)
var divsQuery = document.querySelectorAll("div"); // NodeList (static)

console.log(divs.length); // e.g., 3
console.log(divsQuery.length); // e.g., 3

document.body.appendChild(document.createElement("div")); // add new div

console.log(divs.length); // 4 ✅ updated automatically!
console.log(divsQuery.length); // 3 ❌ still the old snapshot
```

**Element Navigation vs Node Navigation:**

the DOM gives us TWO versions of most navigation properties - one for elements only, one for all nodes:

| Element Version (tags only) | Node Version (includes text, comments, whitespace) |
|-----------------------------|---------------------------------------------------|
| `parentElement` | `parentNode` |
| `children` | `childNodes` |
| `firstElementChild` | `firstChild` |
| `lastElementChild` | `lastChild` |
| `nextElementSibling` | `nextSibling` |
| `previousElementSibling` | `previousSibling` |
| `childElementCount` | `childNodes.length` |

```js
// example - why this matters:
// HTML: <div>   <span>hello</span>   </div>
//       ^ whitespace text nodes exist between tags!

div.childNodes.length;    // 3 (text + span + text)
div.children.length;      // 1 (just span)

div.firstChild;           // #text (the whitespace)
div.firstElementChild;    // <span>hello</span>
```

⚠️ use `Element` versions when you only care about HTML tags, use `Node` versions when you need everything (rare)

**Other useful properties:**

```js
element.innerHTML    // -> HTML content as string (includes tags)
element.outerHTML    // -> same but includes the element itself
element.textContent  // -> text content only (no tags)
element.innerText    // -> visible text only (respects CSS display:none)

element.tagName      // -> tag name in UPPERCASE ("DIV", "SPAN")
element.id           // -> id attribute value
element.className    // -> class attribute as string
element.classList    // -> DOMTokenList (has add/remove/toggle)

element.hasChildNodes()     // -> true/false
element.contains(otherEl)   // -> checks if otherEl is a descendant
element.closest(".class")   // -> finds nearest ancestor matching selector
element.matches(".class")   // -> checks if element matches selector
```

**Node types (nodeType property):**

```js
element.nodeType  // returns a number:
// 1 = Element node (tags like div, span)
// 3 = Text node (text content)
// 8 = Comment node (<!-- comments -->)
// 9 = Document node (the document itself)
// 11 = DocumentFragment node (template, off-DOM container)
```

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

div.insertBefore; //insert between two elements
```

---

## Events

code runs (Event Handler) based on some condition or action done by the user
each element has some events that can be triggered on it

### Three Ways to Handle Events

**1. Inline HTML Attributes (used in frameworks mostly):**

```html
<div onclick="alert('hello')">Click me</div>
<div onmouseenter="mouseEnter()">Hover me</div>
<div onmouseenter="mouseEnter(x, y)">With arguments</div>
<div onclick="handleClick(this)">Pass the element itself</div>
```

- `onclick` is an attribute, the value is js code which can be written directly or as a function call
- we can pass arguments to the function (similar to props in React)
- we can pass `this` which refers to the element that got the event

**2. Element Properties:**

```js
var div = document.querySelector('div');

function test() {
  console.log(arguments);
}

div.onclick = test; // callback - pass the function, NOT the call
// js sends the event object by default
```

**3. DOM Event Listener (recommended):**

```js
var div = document.querySelector("div");

div.addEventListener("click", function() {
  console.log(arguments); // event object is passed
  console.log(this); // returns the div element
});
```

---

### Event Object

the event object holds all properties of the event (each event type has its own properties)

**target vs this:**

```html
<div onclick="handleClick(this, event)">
  <h1>Child</h1>
</div>
```

if we click on the child `<h1>`, the event will still fire because it targets the whole parent element

- `event.target` -> returns what was actually clicked (div OR h1)
- `this` -> always returns the element the handler is attached to (div)

---

### Event Bubbling

when an event fires on a child, it also fires on all parent elements

```html
<form>
  <div>
    <button>1</button>
    <button>2</button>
    <button>3</button>
    <input type="submit">
  </div>
</form>
```

**approach 1 - loop and add listeners:**

```js
var buttons = div.children;
for (var i = 0; i < buttons.length; i++) {
  buttons[i].addEventListener("click", function() {
    console.log(this.textContent); // ✅ 'this' works because each has its own reference
  });
}
```

⚠️ if we use `i` inside the callback instead of `this`, it won't work! the loop finishes before the click happens, so `i` will be out of bounds

**solution using closure (if you don't want to use `this`):**

```js
for (var i = 0; i < buttons.length; i++) {
  (function(x) {
    buttons[x].addEventListener("click", function() {
      console.log(buttons[x].textContent); // ✅ x is scoped to this iteration
    });
  })(i);
}
```

---

### Event Delegation (better approach)

instead of adding listeners to each button, add ONE listener to the parent and check `event.target`:

```js
div.addEventListener("click", function(e) {
  if (e.target.tagName === "BUTTON") {
    console.log(e.target.textContent); // ✅ works for all buttons
  }
});
```

---

## Timing Events

both take a callback function or function body

**setTimeout - runs ONCE after a delay:**

```js
setTimeout(function() {
  console.log("runs after 2 seconds");
}, 2000);
```

**setInterval - runs repeatedly at intervals:**

```js
var myInterval = setInterval(function() {
  console.log("runs every 1 second");
}, 1000);

// to stop it:
clearInterval(myInterval);
```

---

### Form Submit Events

**on the input submit:**

```js
submitButton.onclick = function(e) {
  // e is a PointerEvent (about the button, not the form)
};
```

**on the form (better):**

```js
form.onsubmit = function(e) {
  // e is a SubmitEvent (about the form itself)
  // can access form data, validate inputs, etc.
};
```

⚠️ using `onsubmit` on the form is better because it returns the form's event object, not just a pointer event about the button

---

### Input Events

- `oninput` -> fires **every time** the user changes anything in the input (real-time)
- `onchange` -> fires when the user changes the value AND **loses focus** (blurs out of the input)

**preventing form submission on validation error:**

```js
form.onsubmit = function(e) {
  if (!isValid) {
    e.preventDefault(); // stops form from submitting
  }
};
```
---

### Event Propagation (Bubbling & Capturing)

when an event fires, it doesn't just fire on the clicked element - it travels through the DOM tree

**event bubbling (default):** event goes from child → parent → grandparent (upward)

```
parent (3rd)
   └── child1 (2nd)
         └── child2 (clicked - 1st)
```

**event capturing:** event goes from grandparent → parent → child (downward)

```
parent (1st)
   └── child1 (2nd)
         └── child2 (clicked - 3rd)
```
and both cases we clicked on child.
```js
// bubbling (default) - 3rd parameter is false or omitted
element.addEventListener("click", handler);
element.addEventListener("click", handler, false);

// capturing - 3rd parameter is true
element.addEventListener("click", handler, true);
```

**stopping propagation:**

```js
element.addEventListener("click", function(e) {
  e.stopPropagation(); // stops event from going to parent/child
  // works for both bubbling and capturing
});
```

**checking if the clicked element is the actual target:**

```js
element.addEventListener("click", function(e) {
  if (this === e.target) {
    // clicked directly on this element, not a child we can do this on every element to make sure it's the element we need.
  }
});
```

⚠️ `e.stopPropagation()` stops the event from traveling further, can be used at any point in the chain

---

## BOM Window Methods & Properties

### window.open() / close() / print()

```js
var popup = window.open("https://example.com", "popupName", "width=400,height=300");
// returns a window object - fully customizable and controllable

popup.close(); // close any tabs opened by open()

window.print(); // opens the print dialog
```

---

### window.navigator

contains info about the user's browser, device, and network - helps personalize the experience

```js
navigator.userAgent       // -> browser info string
navigator.userAgentData   // -> contains user software and hardware info (modern)
navigator.language        // -> user's preferred language ("en-US")
navigator.onLine          // -> true/false if user is online
navigator.platform        // -> operating system ("Win32", "MacIntel", "Linux")
navigator.cookieEnabled   // -> true/false if cookies are enabled
navigator.geolocation     // -> access to GPS location (needs permission)
```

---

### window.history

contains the browsing history for the current tab - can navigate the user through their path

```js
history.length       // -> number of pages in history
history.back()       // -> go to previous page (like clicking back button)
history.forward()    // -> go to next page (like clicking forward button)
history.go(-2)       // -> go 2 pages back
history.go(1)        // -> go 1 page forward
```

⚠️ you can only navigate within the user's history, you can't read the actual URLs for security reasons

---

### window.location

contains info about the current URL - can read query strings and navigate to new pages

```js
location.href         // -> full URL "https://example.com/page?name=ahmed&age=25"
location.hostname     // -> "example.com"
location.pathname     // -> "/page"
location.search       // -> "?name=ahmed&age=25" (query string)
location.hash         // -> "#section1" (anchor)
location.protocol     // -> "https:"
```

**getting data from query string:**

```js
// URL: https://example.com/page?name=ahmed&age=25
var params = new URLSearchParams(location.search);
params.get("name");   // -> "ahmed"
params.get("age");    // -> "25"
```

**navigation methods:**

```js
location.reload();              // -> reload the current page
location.href = "newpage.html"; // -> navigate to new page (keeps history)
location.replace("newurl.com"); // -> replace current page in history (can't go back!)
```

⚠️ `replace()` is useful for exams/secure pages - user can't click back to return to the previous page

---

### HTTP is Stateless

⚠️ HTTP is a stateless protocol - when you move from one page to another, all your state (variables, data) is lost

**solutions to persist data:**
- **localStorage / sessionStorage** -> store data in browser
- **cookies** -> small data sent with every request
- **query strings** -> pass data in URL (`?name=ahmed`)
- **database** -> store on server side