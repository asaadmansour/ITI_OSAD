var img1 = document.querySelector("img");
var divIdHeader = document.getElementById("header");
var divId2Header = divIdHeader.cloneNode(true);
var body = document.body;
var divClassCenter = document.getElementsByClassName("center");
var ul = document.getElementById("nav");
console.log(img1);
console.log(ul);

divClassCenter[0].classList.remove("center");
divIdHeader.style.textAlign = "right";
ul.style.margin = "0 auto";
ul.style.width = "0";
divId2Header.style.textAlign = "left";
body.append(divId2Header);
