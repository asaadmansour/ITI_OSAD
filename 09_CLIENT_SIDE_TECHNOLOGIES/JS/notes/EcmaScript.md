# ECMAScript (ES6+)

ES6 (ECMAScript 2015) introduced new syntax as "syntax sugar" - cleaner ways to write JavaScript

**transpilers:** convert new JS to legacy code for older browsers (e.g., Babel)
most modern browsers have built-in support, but we still transpile for full compatibility

---

## Variables: var vs let vs const

| Feature            | `var`               | `let`                  | `const`                |
| ------------------ | ------------------- | ---------------------- | ---------------------- |
| **Scope**          | function            | block                  | block                  |
| **Hoisting**       | hoisted (undefined) | hoisted (throws error) | hoisted (throws error) |
| **Re-declaration** | ✅ allowed          | ❌ error               | ❌ error               |
| **Re-assignment**  | ✅ yes              | ✅ yes                 | ❌ no                  |
| **Initial value**  | optional            | optional               | ⚠️ must initialize     |

**temporal dead zone (TDZ):**

`let` and `const` are hoisted but NOT initialized - accessing them before declaration throws an error

```js
let x = 10;
function test() {
  console.log(x); // ❌ ReferenceError! x is in TDZ
  let x = 20; // x is hoisted but not initialized yet
}
test();
console.log(x); // 10 (outer x)
```

⚠️ this is called the "temporal dead zone" - the variable exists but can't be accessed until initialization

---

## Template Literals

using backticks `` ` `` instead of quotes - allows string interpolation and multi-line strings

```js
// old way (concatenation)
var name = "Ahmed";
var msg = "Hello, " + name + "! You are " + age + " years old.";

// new way (template literals)
var msg = `Hello, ${name}! You are ${age} years old.`;

// multi-line strings
var html = `
  <div>
    <h1>${title}</h1>
    <p>${content}</p>
  </div>
`;
```

---

## Arrow Functions

shorter syntax for anonymous functions

```js
// old way
var add = function (a, b) {
  return a + b;
};

// arrow function
var add = (a, b) => {
  return a + b;
};

// one line - can remove {} and return
var add = (a, b) => a + b;

// one argument - can remove ()
var double = (x) => x * 2;

// no arguments - need empty ()
var greet = () => "hello";
```

**⚠️ arrow functions DON'T have their own `this`:**

```js
var obj = {
  name: "Ahmed",

  // regular function - has its own 'this'
  sayHi: function () {
    console.log(this.name); // "Ahmed"
  },

  // arrow function - inherits 'this' from parent scope
  sayHiArrow: () => {
    console.log(this.name); // undefined! 'this' is window
  },
};
```

⚠️ use regular functions for object methods, arrow functions for callbacks

---

## Destructuring

extract values from arrays/objects into variables in one line

**array destructuring:**

```js
var arr = [1, 3];

// old way
var x = arr[0];
var y = arr[1];

// new way (destructuring)
let [x, y] = arr; // x = 1, y = 3
let [x, y, z] = arr; // z = undefined (doesn't exist)

// can initialize directly
let [a, b, c] = [1, 2, "asaad"]; // c = "asaad"

// skip values with empty slots
let [first, , third] = [1, 2, 3]; // first = 1, third = 3

// from function return
function test() {
  return [1, 2];
}
let [x, y] = test(); // x = 1, y = 2
```

**object destructuring:**

```js
// old way
let x = window.name;

// new way - extract and rename
let { name: x, location: y } = window; // x = window.name, y = window.location

// if variable name is same as property name
let { name, location } = window; // name = window.name, location = window.location

// default values (if property doesn't exist)
let { name, foo = "default" } = window; // foo = "default" if not in window
```

⚠️ if attribute does not exist in the object, it will be `undefined` (unless you set a default)

---

## Spread and Rest Operator (...)

the `...` operator works differently based on where it's used

**rest parameter (in function parameters):** collects remaining arguments into an array

```js
function test(...x) {
  console.log(x);
}
test(1); // [1]
test(1, 2, 3, 4); // [1, 2, 3, 4]
test(); // []

// with other parameters - rest MUST be last
function test(a, ...rest) {
  console.log(a); // first argument
  console.log(rest); // remaining as array
}
test(1, 2, 3, 4); // a = 1, rest = [2, 3, 4]
test(); // a = undefined, rest = []
```

⚠️ rest parameter must be the LAST parameter

**spread operator (expanding arrays/objects):** spreads elements into individual values

```js
var arr1 = [1, 2, 3];
var arr2 = [4, 5, 6];

// combining arrays
var arr3 = [...arr1, ...arr2]; // [1, 2, 3, 4, 5, 6]
var arr4 = [...arr1, arr2]; // [1, 2, 3, [4, 5, 6]] - without spread!

// passing array elements as function arguments
Math.max(arr1); // NaN (can't take array)
Math.max(...arr1); // 3 (spreads as Math.max(1, 2, 3))

// copying arrays (shallow copy, but copies primitives correctly)
var original = [1, 2, 3];
var copy = original; // ❌ same reference, not a copy!
var realCopy = [...original]; // ✅ new array with copied values

// spread with objects (ES2018)
var obj1 = { a: 1, b: 2 };
var obj2 = { ...obj1, c: 3 }; // { a: 1, b: 2, c: 3 }
```

⚠️ spread creates a **shallow copy** - nested objects/arrays are still references

---

## User Defined Objects

objects are key-value pairs that can hold properties and methods
all objects inherit from `Object` (the parent of all objects in JavaScript)

**creating objects:**

```js
// object literal (most common)
let obj = {};

// using Object constructor
let obj = new Object();

// with initial properties
let obj = { name: "asaad", age: 22 };
```

**adding/modifying properties:**

```js
let obj = { name: "asaad" };

// add new property
obj.age = 22;

// overwrite existing property
obj.age = 21;

// add nested objects
obj.address = { country: "egypt", city: "cairo" };
```

**accessing properties:**

```js
// dot notation
console.log(obj.name);           // "asaad"
console.log(obj.address.country); // "egypt"

// bracket notation (subscribe notation)
console.log(obj["age"]);         // 22

// useful when property name is in a variable
let key = "age";
console.log(obj[key]);           // 22
obj[key] = 60;                   // updates age to 60
```

⚠️ accessing a non-existent property returns `undefined`

```js
console.log(obj.eyes); // undefined (doesn't exist)
```

**storing functions in objects:**

```js
// object can hold functions (methods)
obj.print = (x) => console.log(x);

// calling the method
obj.print("hello"); // "hello"

// or define inline
let person = {
  name: "asaad",
  greet: function() {
    console.log("Hello, " + this.name);
  }
};
person.greet(); // "Hello, asaad"
```

**deleting properties:**

```js
delete obj.name;
console.log(obj.name); // undefined (deleted)
```

**looping over object properties:**

```js
let obj = { name: "asaad", age: 22, city: "cairo" };

// for...in loop - iterates over keys
for (let key in obj) {
  console.log(key);       // "name", "age", "city" (strings)
  console.log(obj[key]);  // "asaad", 22, "cairo" (values)
}
```

⚠️ use `obj[key]` not `obj.key` in loops - `obj.key` looks for a property literally named "key"

---

## Changing `this` with call, apply, and bind

these methods let you change what `this` refers to when calling a function

| Method    | Description                                     | Arguments                  |
| --------- | ----------------------------------------------- | -------------------------- |
| `call()`  | calls function immediately with new `this`      | `(thisArg, arg1, arg2...)` |
| `apply()` | same as call, but arguments as array            | `(thisArg, [arg1, arg2])` |
| `bind()`  | returns new function with bound `this` (no call)| `(thisArg, arg1, arg2...)` |

**borrowing array methods for strings:**

```js
var str = "asaad";

// strings don't have forEach, but arrays do
// borrow forEach from array and use string as 'this'
[].forEach.call(str, function(char) {
  console.log(char); // "a", "s", "a", "a", "d"
});

// same with apply (arguments as array)
[].forEach.apply(str, [function(char) {
  console.log(char);
}]);

// bind returns a new function for later use
let forEachOnStr = [].forEach.bind(str);
forEachOnStr(function(char) {
  console.log(char);
});
```

**changing `this` in object methods:**

```js
let person = {
  name: "asaad",
  age: 21,
  print: function() {
    console.log(person.name, person.age); // hardcoded - won't work with call
  }
};

let employee = {
  name: "amr",
  age: 22
};

person.print.call(employee); // still prints "asaad", 21 (hardcoded!)
```

**making methods generic with `this`:**

```js
let person = {
  name: "asaad",
  age: 21,
  print: function() {
    console.log(this.name, this.age); // uses 'this' - now it's generic!
  }
};

let employee = {
  name: "amr",
  age: 22
};

person.print();              // "asaad", 21 (this = person)
person.print.call(employee); // "amr", 22 (this = employee)
```

**the `this` problem with callbacks:**

```js
let person = {
  name: "asaad",
  age: 21,
  init: function() {
    // inside this function, 'this' = person
    
    document.querySelector("div").addEventListener("click", function() {
      // ❌ inside callback, 'this' = the div element, NOT person!
      console.log(this.name, this.age); // undefined, undefined
    });
  }
};
```

**solutions for `this` in callbacks:**

```js
// solution 1: arrow function (inherits 'this' from parent scope)
let person = {
  name: "asaad",
  age: 21,
  init: function() {
    document.querySelector("div").addEventListener("click", () => {
      console.log(this.name, this.age); // ✅ "asaad", 21
    });
  }
};

// solution 2: bind() to preserve 'this'
let person = {
  name: "asaad",
  age: 21,
  init: function() {
    setTimeout(function() {
      console.log(this.name, this.age); // ✅ "asaad", 21
    }.bind(this), 1000);
  }
};

// solution 3: store 'this' in a variable (older pattern)
let person = {
  name: "asaad",
  age: 21,
  init: function() {
    var self = this; // save reference
    setTimeout(function() {
      console.log(self.name, self.age); // ✅ "asaad", 21
    }, 1000);
  }
};
```

⚠️ arrow functions don't have their own `this` - they inherit from parent scope, making them perfect for callbacks

---
## Constructor Functions and the `new` Keyword

**"functions are first-class objects"** - in JavaScript, functions are objects that can have properties and methods

**the `new` keyword is the magic:**

```js
// without 'new' - just a regular function call
function Employee() {
  console.log(this); // 'this' refers to window (the caller)
}
Employee(); // logs: Window object

// with 'new' - creates a new object!
function Employee(n, a) {
  console.log(this); // 'this' refers to the newly created object!
  this.name = n;
  this.age = a;
  // implicitly returns {} (the new object)
}

let emp = new Employee("asaad", 21);
// emp is now an object of type Employee with a constructor!
console.log(emp.name); // "asaad"
console.log(emp.age);  // 21
```

**what `new` does behind the scenes:**

1. creates a new empty object `{}`
2. sets `this` to point to that new object
3. links the object to the constructor's prototype
4. implicitly returns the object

---

## Prototypes

**functions are objects** - they have properties we can access with dot notation

every function has a special property called `prototype` which is itself an `Object` with a `constructor` property

```js
// JavaScript automatically creates:
// Employee.prototype = { constructor: Employee }

function Employee(name, age) {
  this.name = name;
  this.age = age;
}

// the problem with methods inside constructor:
function Employee(name, age) {
  this.name = name;
  this.age = age;
  this.print = function() {
    console.log(this.name, this.age);
  };
  // ⚠️ BAD PERFORMANCE: each object gets its own copy of print() in memory!
}
```

**solution: use prototype for shared methods**

just like arrays have `.length` on their prototype (not on each instance), we can add methods to prototype

```js
function Employee(name, age) {
  this.name = name;
  this.age = age;
}

// add method to prototype - shared by ALL instances!
Employee.prototype.print = function() {
  console.log(this.name, this.age);
};

let emp1 = new Employee("asaad", 21);
let emp2 = new Employee("ahmed", 25);

emp1.print(); // "asaad", 21
emp2.print(); // "ahmed", 25

// both emp1 and emp2 share the SAME print function
console.log(emp1.print === emp2.print); // true ✅ (same reference)
```

**how prototype lookup works:**

```js
// when you call emp1.print():
// 1. JavaScript looks for 'print' on emp1 object - not found
// 2. JavaScript looks in emp1's prototype (Employee.prototype) - found!
// 3. executes the function with 'this' set to emp1

// you can also add to built-in prototypes (use carefully!)
Array.prototype.first = function() {
  return this[0];
};
[1, 2, 3].first(); // 1
```

⚠️ methods on prototype = better performance (shared memory)
⚠️ methods in constructor = each instance has its own copy (more memory)

---

## Factory Functions

factory functions create and return new objects - useful for creating multiple similar objects

```js
// factory function
function createPerson(name, age) {
  return {
    name: name,
    age: age,
    greet: function() {
      console.log("Hi, I'm " + this.name);
    }
  };
}

// create multiple objects
let person1 = createPerson("asaad", 22);
let person2 = createPerson("ahmed", 25);

person1.greet(); // "Hi, I'm asaad"
person2.greet(); // "Hi, I'm ahmed"
```

**shorthand property syntax (ES6):** if variable name matches property name

```js
function createPerson(name, age) {
  return {
    name,  // same as name: name
    age,   // same as age: age
    greet() {  // shorthand method syntax
      console.log("Hi, I'm " + this.name);
    }
  };
}
```

**factory vs constructor functions:**

| Feature           | Factory Function          | Constructor Function        |
| ----------------- | ------------------------- | --------------------------- |
| Syntax            | `createPerson()`          | `new Person()`              |
| Returns           | explicit `return {}`      | implicit return             |
| `this`            | not used (or explicitly)  | refers to new object        |
| Prototype methods | ❌ not easy               | ✅ `Person.prototype.method`|
| `instanceof`      | ❌ doesn't work           | ✅ works                    |

---

## ES6 Classes

ECMAScript made classes as **syntactic sugar** over constructor functions - cleaner syntax, same behavior

**basic class syntax:**

```js
class Employee {
  // constructor - called when using 'new'
  constructor(n, a, s) {
    this.name = n;
    this.age = a;
    this.salary = s;
  }
}

let emp = new Employee("asaad", 22, 21111);
console.log(emp.name); // "asaad"
```

**adding validation in constructor:**

```js
class Employee {
  constructor(n, a, s) {
    // type checking
    if (typeof n !== "string") {
      throw new Error("Name must be a string!");
    }
    this.name = n;
    this.age = a;
    this.salary = s;
  }
}

new Employee(123, 22, 5000); // ❌ Error: Name must be a string!
```

**no method overloading in JavaScript:**

JavaScript doesn't support multiple constructors with different parameters - we can already pass any number of arguments

**solution: use default parameter values**

```js
class Employee {
  constructor(n, a = 0, s = 0) {  // default values for age and salary
    if (typeof n !== "string") {
      throw new Error("Name must be a string!");
    }
    this.name = n;
    this.age = a;
    this.salary = s;
  }
}

let emp1 = new Employee("asaad", 22, 5000); // all params
let emp2 = new Employee("ahmed", 25);       // salary defaults to 0
let emp3 = new Employee("sara");            // age and salary default to 0
```

---

## Private Fields and Getters/Setters

**private fields with `#`:**

prefix with `#` to make a field private - cannot be accessed outside the class

```js
class Employee {
  #name;  // private field - must declare before using
  #salary;

  constructor(n, a, s) {
    this.#name = n;   // private
    this.age = a;     // public
    this.#salary = s; // private
  }
}

let emp = new Employee("asaad", 22, 5000);
console.log(emp.age);     // 22 ✅ (public)
console.log(emp.name);    // undefined ❌ (no public 'name' property)
console.log(emp.#name);   // ❌ SyntaxError! private field
```

**getters and setters:**

use `get` and `set` to control access to properties - they're accessed like properties, not called like functions!

```js
class Employee {
  #name;

  constructor(n, a) {
    this.#name = n;
    this.age = a;
  }

  // getter - access with emp.name (no parentheses!)
  get name() {
    return this.#name;
  }

  // setter - set with emp.name = "value" (no parentheses!)
  set name(value) {
    if (typeof value !== "string") {
      throw new Error("Name must be a string!");
    }
    this.#name = value;
  }
}

let emp = new Employee("asaad", 22);
console.log(emp.name);  // "asaad" (calls getter)
emp.name = "ahmed";     // calls setter
console.log(emp.name);  // "ahmed"
emp.name = 123;         // ❌ Error: Name must be a string!
```

⚠️ getters/setters are added to the **prototype** as properties, not in the constructor

---

## Class Methods

**methods defined in class go to prototype automatically:**

```js
class Employee {
  #name;

  constructor(n, a) {
    this.#name = n;
    this.age = a;
  }

  // method - automatically added to Employee.prototype!
  print() {
    console.log(this.#name, this.age);
  }

  // another method
  giveRaise(amount) {
    this.salary += amount;
  }
}

let emp1 = new Employee("asaad", 22);
let emp2 = new Employee("ahmed", 25);

emp1.print(); // "asaad", 22
emp2.print(); // "ahmed", 25

// both share the same method (good for memory!)
console.log(emp1.print === emp2.print); // true ✅
```

⚠️ JavaScript automatically adds class methods to the prototype (not to each instance) - better memory performance!

---

## Static Methods and Properties

**static methods belong to the class itself, not instances:**

```js
class Employee {
  constructor(name, age) {
    this.name = name;
    this.age = age;
  }

  // instance method - goes to prototype
  print() {
    console.log(this.name, this.age);
  }

  // static method - belongs to Employee class itself
  static createAnonymous() {
    return new Employee("Anonymous", 0);
  }
}

let emp = new Employee("asaad", 22);
emp.print();              // ✅ works (instance method)
emp.createAnonymous();    // ❌ Error! instances don't see static methods

Employee.createAnonymous(); // ✅ works (called on class)
```

**how static works natively (without `class` syntax):**

```js
// static methods are just properties on the constructor function itself
function Employee(name) {
  this.name = name;
}

// instance method - on prototype (instances can see it)
Employee.prototype.print = function() {
  console.log(this.name);
};

// static method - on the function object itself (instances can't see it)
Employee.createAnonymous = function() {
  return new Employee("Anonymous");
};

let emp = new Employee("asaad");
emp.print();              // ✅ works
Employee.createAnonymous(); // ✅ works
emp.createAnonymous();    // ❌ undefined (instances only see prototype)
```

⚠️ instances only see **prototype** - static methods are on the class/constructor object itself

**creating a "static class" (utility class):**

to prevent instantiation, throw an error in the constructor

```js
class MathUtils {
  constructor() {
    throw new Error("MathUtils cannot be instantiated!");
  }

  static add(a, b) {
    return a + b;
  }

  static multiply(a, b) {
    return a * b;
  }
}

MathUtils.add(5, 3);      // 8 ✅
new MathUtils();          // ❌ Error: MathUtils cannot be instantiated!
```

---

## Inheritance with `extends`

use `extends` to inherit from a parent class, and `super()` to call the parent constructor

```js
class Person {
  constructor(name, age) {
    this.name = name;
    this.age = age;
  }

  greet() {
    console.log(`Hi, I'm ${this.name}`);
  }
}

class Employee extends Person {
  constructor(name, age, salary) {
    super(name, age);  // MUST call parent constructor first!
    this.salary = salary;
  }

  // override parent method
  greet() {
    console.log(`Hi, I'm ${this.name} and I work here`);
  }

  // call parent method with super
  greetFormal() {
    super.greet();  // calls Person's greet()
    console.log(`My salary is ${this.salary}`);
  }
}

let emp = new Employee("asaad", 22, 5000);
emp.greet();        // "Hi, I'm asaad and I work here" (overridden)
emp.greetFormal();  // "Hi, I'm asaad" then "My salary is 5000"

console.log(emp instanceof Employee); // true
console.log(emp instanceof Person);   // true (inheritance chain)
```

⚠️ in child constructor, you **MUST call `super()` before using `this`**

---

## Prototype Chaining and Method Override

**every function's prototype points to Object:**

```js
function Employee(name) {
  this.name = name;
}

// prototype chain:
// emp → Employee.prototype → Object.prototype → null

console.log(Employee.prototype.constructor); // Employee
console.log(Object.getPrototypeOf(Employee.prototype)); // Object.prototype
```

**how method override works - "the closer function wins":**

JavaScript looks for methods starting from the object, then up the prototype chain - the **first match** is used

```js
class Person {
  greet() {
    console.log("Hello from Person");
  }
}

class Employee extends Person {
  // override - this is "closer" to the instance
  greet() {
    console.log("Hello from Employee");
  }
}

let emp = new Employee();
emp.greet(); // "Hello from Employee" (closer wins!)

// lookup order:
// 1. emp object itself - not found
// 2. Employee.prototype - FOUND! uses this one
// 3. Person.prototype - never reached (already found above)
```

⚠️ to override, just define the method again in the child class - the "closer" one gets called first (prototype chaining)

---

## Abstract Classes

JavaScript doesn't have true abstract classes, but we can simulate them by checking `this.constructor`

**simulating abstract class:**

```js
class Shape {
  constructor() {
    // prevent direct instantiation of Shape
    if (this.constructor === Shape) {
      throw new Error("Shape is abstract - cannot instantiate directly!");
    }
  }

  // "abstract" method - should be overridden
  getArea() {
    throw new Error("getArea() must be implemented by subclass!");
  }
}

class Rectangle extends Shape {
  constructor(width, height) {
    super();  // calls Shape constructor, but this.constructor === Rectangle ✅
    this.width = width;
    this.height = height;
  }

  // override the abstract method
  getArea() {
    return this.width * this.height;
  }
}

new Shape();              // ❌ Error: Shape is abstract!
let rect = new Rectangle(5, 10);  // ✅ works (this.constructor === Rectangle)
rect.getArea();           // 50 ✅
```

**why it works:**

- when `new Shape()` is called → `this.constructor === Shape` → throws error ❌
- when `new Rectangle()` is called → `super()` runs Shape's constructor, but `this.constructor === Rectangle` → allowed ✅

⚠️ child classes call `super()` but their `this.constructor` points to themselves, not the parent

---

## Modules

coming soon...

---

## Array Higher-Order Methods

these methods take a callback function and return a new result (don't modify original array)

**filter():** returns a new array with elements that pass the condition

```js
let arr = [1, 3, 6, 8, 2, 10];

let filtered = arr.filter((el, index, arr) => el > 5);
console.log(filtered); // [6, 8, 10]

// returns empty array if none found
let none = arr.filter(el => el > 100);
console.log(none); // []
```

**find():** returns the FIRST element that matches the condition

```js
let arr = [1, 3, 6, 8, 2, 10];

let found = arr.find(el => el > 5);
console.log(found); // 6 (first match)

// returns undefined if not found
let notFound = arr.find(el => el > 100);
console.log(notFound); // undefined
```

**findIndex():** returns the INDEX of the first element that matches

```js
let arr = [1, 3, 6, 8, 2, 10];

let index = arr.findIndex(el => el > 5);
console.log(index); // 2 (index of 6)

// returns -1 if not found
let notFound = arr.findIndex(el => el > 100);
console.log(notFound); // -1
```

**map():** applies an expression to each element and returns a new array

```js
let arr = [1, 2, 3, 4, 5];

let mapped = arr.map(el => el * 2);
console.log(mapped); // [2, 4, 6, 8, 10]

// original array is not modified
console.log(arr); // [1, 2, 3, 4, 5]
```

**Array.from():** converts iterables (strings, NodeLists, etc.) to arrays

```js
Array.from("asaad");          // ["a", "s", "a", "a", "d"]
Array.from([1, 2, 3]);        // [1, 2, 3]
Array.from(document.querySelectorAll("div")); // converts NodeList to array

// works on anything with Symbol.iterator (iterables)
```

| Method | Returns | If Not Found |
|--------|---------|--------------|
| `filter()` | new array with matches | empty array `[]` |
| `find()` | first matching element | `undefined` |
| `findIndex()` | index of first match | `-1` |
| `map()` | new array (same length) | - |

---

## Async JavaScript & Event Loop

**JavaScript is single-threaded** - it can only do one thing at a time

but we can do async operations using Web APIs (browser handles them separately)

**how the event loop works:**

```
┌───────────────────────────┐
│     Execution Stack       │ ← runs your code (LIFO)
│  (Call Stack)             │
└───────────────────────────┘
            ↓ async calls
┌───────────────────────────┐
│        Web APIs           │ ← browser handles: setTimeout, fetch, DOM events
│  (setTimeout, fetch, etc) │
└───────────────────────────┘
            ↓ when done
┌───────────────────────────┐
│     Message Queue         │ ← callbacks wait here (FIFO)
│  (Callback Queue)         │
└───────────────────────────┘
            ↓ event loop pushes to stack when empty
            ↑
     [Event Loop] - checks if stack is empty, then moves callbacks from queue to stack
```

**Global Execution Context:** when JS starts, it creates a global context after hoisting (variables are declared but not initialized)

**example walkthrough:**

```js
console.log("1");

setTimeout(() => {
  console.log("2");
}, 2000);

console.log("3");

// Output: "1", "3", "2" (after 2 seconds)
```

**what happens step by step:**

1. `console.log("1")` → pushed to stack → executed → popped
2. `setTimeout(callback, 2000)` → pushed to stack → callback sent to **Web API** → setTimeout popped
3. `console.log("3")` → pushed to stack → executed → popped
4. **Stack is now empty**
5. After 2 seconds, Web API moves callback to **Message Queue**
6. **Event Loop** sees stack is empty → moves callback to stack
7. Callback executes → `console.log("2")`

⚠️ even if setTimeout is set to 0ms, the callback still goes through the queue - it runs after the current stack is empty!

**the callback hell problem:**

when we need data from async operations in sequence, we end up nesting callbacks

```js
// ❌ callback hell - hard to read and maintain
getData(function(a) {
  getMoreData(a, function(b) {
    getEvenMoreData(b, function(c) {
      getFinalData(c, function(d) {
        console.log(d);
      });
    });
  });
});
```

---
const data = await response.json();
## Promises

promises solve callback hell by providing a cleaner way to handle async operations

**a Promise is an object** that represents a future value - it can be:
- **Pending** → waiting for result
- **Fulfilled** (resolved) → operation succeeded
- **Rejected** → operation failed

⚠️ promise itself is NOT async - it depends on the callback function you pass!

**creating a promise:**

```js
let myPromise = new Promise(function(resolve, reject) {
  // async operation here
  
  let success = true;
  
  if (success) {
    resolve("Data loaded!");   // call when successful
  } else {
    reject("Error occurred!"); // call when failed
  }
});
```

**using a promise:**

```js
myPromise
  .then(result => {
    // runs when resolve() is called
    console.log(result); // "Data loaded!"
  })
  .catch(error => {
    // runs when reject() is called
    console.log(error); // "Error occurred!"
  });
```

**chaining promises (solving callback hell):**

```js
// ✅ much cleaner than nested callbacks
getData()
  .then(a => getMoreData(a))
  .then(b => getEvenMoreData(b))
  .then(c => getFinalData(c))
  .then(d => console.log(d))
  .catch(error => console.log("Error:", error));
```

**promise states:**

```js
let p = new Promise((resolve, reject) => {
  setTimeout(() => resolve("done"), 1000);
});

console.log(p); // Promise { <pending> }

// after 1 second:
// Promise { <fulfilled>: "done" }
```

⚠️ `.then()` is called when `resolve()` is called, `.catch()` is called when `reject()` is called

we usually wrap the promise in a function like 
function getUserData(id) {
  let p = new Promise((resolve, reject) => {
  setTimeout(() => resolve("done"), 1000);
});
}


async / await

let ids = await getids() bec if we didnt use await ids will held a pending promise so await makes it wait until it load
but we must wrap it in a async function
(async function() {
  let ids = await getids();
})();


json.parse(jsonobj) return js obj;
json.stringify(jsobj) return json;

// ajax request is a concept where the page does not referesh when a api call happen
async javascript and xml
const xhr = new XMLHttpRequest();
xhr.open('GET', 'https://api.example.com/data');
xhr.onload = function () {
  if (xhr.status === 200) {
    console.log(JSON.parse(xhr.responseText));
  }
};
xhr.send();

newer way 

// GET
const response = await fetch('https://api.example.com/data');
const data = await response.json();
