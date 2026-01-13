var openBtn = document.querySelector("#open");
let page2;

openBtn.addEventListener("click", () => {
  page2 = window.open("./page2.html");
  setTimeout(() => {
    page2.close();
  }, 5000);
});


