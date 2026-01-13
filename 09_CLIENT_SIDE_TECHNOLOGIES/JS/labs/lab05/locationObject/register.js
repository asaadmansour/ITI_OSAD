var btnRegister = document.getElementById("register");
var formWindow;
var closeTimer;
btnRegister.addEventListener("click", () => {
  formWindow = window.open("./form.html");
  closeTimer = setTimeout(() => {
    if (formWindow && !formWindow.closed) {
      formWindow.close();
    }
  }, 5000);
});
function clearTimer() {
    clearTimeout(closeTimer);
}