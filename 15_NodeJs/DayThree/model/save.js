const fs = require("fs");
function save(itemsArray, filePath) {
  const writeStream = fs.createWriteStream(filePath);
  writeStream.write(JSON.stringify(itemsArray));
  writeStream.end();
}
module.exports = save;
