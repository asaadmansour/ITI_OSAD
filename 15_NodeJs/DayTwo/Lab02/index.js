const http = require("http");
const fs = require("fs");
const path = require("path");
const filePath = path.join(__dirname, "inventory.json");
const data = JSON.parse(fs.readFileSync(filePath, "utf-8"));

// console.log(data.toString());
const server = http.createServer(async (req, res) => {
  const { url, method } = req;
  if (url == "/") {
    try {
      res.writeHead(200, { "Content-Type": "text/html" });
      let html = "";
      console.log(data.length);
      html += `<html>
      <header>
        <link href="/style.css" rel="stylesheet">
      <title>node</title></header>
      <h1>hello from the server</h1>
      <body class="items">
      `;
      for (let i = 0; i < data.length; i++) {
        console.log(data[i]);
        html += `<div class="divOne">Item: ${data[i].itemName} - Quantity: ${data[i].quantity} - Category: ${data[i].category}</div>`;
      }
      html += `</body></html>`;

      res.end(html);
    } catch (err) {
      res.end("Error handling data");
    }
  } else if (url == "/style.css") {
    const filePath = path.join(__dirname, "style.css");
    fs.readFile(filePath, (err, data) => {
      if (err) {
        res.end("cannot read file");
      } else {
        res.writeHead(200, { "Content-Type": "text/css" });
        // console.log(data.toString());
        res.end(data);
      }
    });
  } else if (url == "/imageOne") {
    const imagePath = path.join(__dirname, "1.jpg");
    res.writeHead(200, { "Content-Type": "image/jpeg" });
    fs.readFile(imagePath, (err, data) => {
      if (err) {
        res.end("Error loading the image");
        return;
      }
      res.end(data);
    });
  } else if (url == "/imageTwo") {
    const imagePath = path.join(__dirname, "2.jpeg");
    res.writeHead(200, { "Content-Type": "image/jpeg" });
    const imageStream = fs.createReadStream(imagePath);
    imageStream.on("error", (err) => {
      res.writeHead(404);
      res.end("Error Loading the Image");
      console.log(err);
    });
    imageStream.pipe(res);
  } else if (url == "/astronomy") {
    let html = "";
    html += `<html><header><link href="http://127.0.0.1:3000/style.css" rel="stylesheet"></header>
    <body><img src="http://127.0.0.1:3000/imageOne"><p>pretty stars</p></body></html>`;
    res.writeHead(200, { "Content-Type": "text/html" });
    res.end(html);
  } else if (url == "/serbal") {
    let html = "";
    html += `<html><body><header><link href="http://127.0.0.1:3000/style.css" rel="stylesheet"></header>
    <img src="http://127.0.0.1:3000/imageTwo"><p>pretty serbal</p></body></html>`;
    res.writeHead(200, { "Content-Type": "text/html" });
    res.end(html);
  } else if (url == "/astronomy/download") {
    const imagePath = path.join(__dirname, "1.jpg");
    res.writeHead(200, {
      "Content-Type": "image/jpeg",
      "Content-Disposition": "attachment; filename=astronomy.jpg",
    });
    const imageStream = fs.createReadStream(imagePath);
    imageStream.on("error", () => {
      res.writeHead(404);
      res.end("Error loading image");
    });
    imageStream.pipe(res);
  } else {
    res.writeHead(404, { "Content-Type": "text/html" });
    res.end("<h1>404 - Page Not Found</h1>");
  }
  console.log(url, method);
  //   console.log(req);
});
server.listen(3000, () => {
  console.log("running and listening");
});
