var div = document.getElementById("mainDiv");
console.log(div);
var body = document.body;
div.addEventListener("click", function () {
  cloneAndInsert(this, body);
});

function randomRGB() {
  return Math.floor(Math.random() * 256);
}
function cloneAndInsert(element, body) {
  var div = element.cloneNode(true);
  div.style.backgroundColor = `rgb(${randomRGB()},${randomRGB()},${randomRGB()})`;
  body.append(div);
}
