// const http = require("http");
// const fs = require("fs");
// const path = require("path");
// const filePath = path.join(__dirname, "inventory.json");
// let content = "";
// let dataArrived = false;
// const readStream = fs.createReadStream(filePath);

// // console.log(file);
// const server = http.createServer(async (req, res) => {
//   const { url, method } = req;
//   if (url == "/") {
//     try {
//       const data = await getItems();
//       res.writeHead(200, { "Content-Type": "application/json" });
//       res.end(data);
//     } catch (err) {
//       res.end("Error handling data");
//     }
//   }
//   console.log(url, method);
//   //   console.log(req);
// });
// function getItems() {
//   return new Promise((res, rej) => {
//     readStream.on("data", (chunk) => {
//       content += chunk;
//     });
//     readStream.on("end", () => {
//       res(content);
//     });
//     readStream.on("error", () => {
//       rej(content);
//     });
//   });
// }
// (async () => {
//   console.log("Loading file...");
//   const data = await getItems();
//   console.log("File loaded!");

//   server.listen(3000, () => {
//     console.log("Server ready on http://localhost:3000");
//   });
// })();
