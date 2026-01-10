var text = document.getElementById("text");
text.addEventListener("keypress", function(e) {
    if (!isFinite(e.key)) {
        e.preventDefault(); 
    }
});