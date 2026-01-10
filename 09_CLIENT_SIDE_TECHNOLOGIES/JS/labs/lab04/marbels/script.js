var div = document.getElementById("imgHolder");
var imgs = div.getElementsByTagName("img"); 
var index = 0;
var interval;
function fn() {
    var previousIndex = (index - 1 + imgs.length) % imgs.length;
    imgs[previousIndex].setAttribute("src","./marble1.jpg");
    imgs[index].setAttribute("src","./marble2.jpg");
    index = (index + 1) % imgs.length;
}

interval = setInterval(fn, 1000);
div.addEventListener("mouseenter",function() {
    clearInterval(interval);
})
div.addEventListener("mouseleave",function() {
   interval =  setInterval(fn,1000);
})