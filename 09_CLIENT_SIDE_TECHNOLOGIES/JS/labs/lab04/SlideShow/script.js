var next = document.getElementById("next");
var slideShow = document.getElementById("slideshow");
var stop = document.getElementById("stop");
var preivous = document.getElementById("previous");
var img = document.getElementById("img");
var pics = ["1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg"];
console.log(next,slideShow,stop,preivous,img);
var index = 0;
var intervalId ;
function nextFn() {
    index = (index + 1) % pics.length;
    img.setAttribute("src",pics[index]);
} 
function prevFn() {
    index = (index - 1 + pics.length) % pics.length;
    img.setAttribute("src",pics[index]);
}
function slideShowFn() {
   intervalId =  setInterval(nextFn,2000);
}
function stopSlideShow() {
    clearInterval(intervalId);
}
img.setAttribute("src",pics[index])
next.addEventListener("click",nextFn);
preivous.addEventListener("click",prevFn);
slideShow.addEventListener("click",slideShowFn);
stop.addEventListener("click",stopSlideShow);