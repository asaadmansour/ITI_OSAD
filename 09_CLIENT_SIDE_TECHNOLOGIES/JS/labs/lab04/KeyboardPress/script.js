var text = document.getElementById("text");
console.log(text);
text.addEventListener("keydown",function(e) {
    if(e.altKey) {
        console.log("Alt key " + e.key.charCodeAt(0))
    } else if(e.ctrlKey)
        console.log("Ctrl key " + e.key.charCodeAt(0))
      else if(e.shiftKey)
        console.log("shit key " + e.key.charCodeAt(0))
      else 
        console.log("Key " + e.key + " Ascii code "+ e.key.charCodeAt(0));
    
})