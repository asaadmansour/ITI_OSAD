const math = require('./math.js');
console.log(math.add(5, 3)); // 8

// (function(exports, require, module, __filename, __dirname) {
//   // require() returns what math.js put in module.exports
//   const math = require('./math.js'); 
//   // math is now { add: [Function], subtract: [Function] }
  
//   console.log(math.add(5, 3)); // 8
  
// })(module.exports, require, module, '/path/to/app.js', '/path/to');