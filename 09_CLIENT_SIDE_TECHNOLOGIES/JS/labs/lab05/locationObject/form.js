var form = document.getElementById("form");

form.addEventListener("submit", () => {
  if (window.opener && window.opener.clearTimer) {
    window.opener.clearTimer();
  }
});