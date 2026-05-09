const add = (a, b) => a + b;
const subtract = (a, b) => a - b;

module.exports = { add, subtract };

// (function(exports, require, module, __filename, __dirname) {
//   // Your code runs here:
//   const add = (a, b) => a + b;
//   const subtract = (a, b) => a - b;
  
//   // When you do this:
//   module.exports = { add, subtract };
  
//   // You're modifying the module.exports object that was passed in
//   // module.exports now points to: { add: [Function], subtract: [Function] }
  
// })(module.exports, require, module, '/path/to/math.js', '/path/to');