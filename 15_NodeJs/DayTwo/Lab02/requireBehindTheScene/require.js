// function require(modulePath) {
//   // 1. Resolve the full path
//   const absolutePath = resolveModulePath(modulePath); // '/full/path/to/math.js'

//   // 2. Check if already cached (modules are cached after first load)
//   if (require.cache[absolutePath]) {
//     return require.cache[absolutePath].exports;
//   }

//   // 3. Read the file as a string
//   const fileContent = fs.readFileSync(absolutePath, 'utf8');
//   // fileContent is now: "const add = (a, b) => a + b; ..."

//   // 4. Create a new module object for this file
//   const module = {
//     exports: {},
//     id: absolutePath,
//     filename: absolutePath,
//     loaded: false
//   };

//   // 5. Create the wrapper function
//   const wrapper = `(function(exports, require, module, __filename, __dirname) {
//     ${fileContent}
//   });`;

//   // 6. Execute the wrapper
//   const compiledWrapper = eval(wrapper); // or vm.runInThisContext()

//   // 7. Call the wrapper with the 5 arguments
//   compiledWrapper(
//     module.exports,           // exports (reference to module.exports)
//     require,                  // require function
//     module,                   // module object
//     absolutePath,             // __filename
//     path.dirname(absolutePath) // __dirname
//   );

//   // 8. Mark as loaded and cache it
//   module.loaded = true;
//   require.cache[absolutePath] = module;

//   // 9. Return whatever was assigned to module.exports
//   return module.exports;
// }
