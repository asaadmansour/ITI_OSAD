var pClock = document.getElementById("clock");
console.log(pClock);

// console.log(`${hours}:${minutes}:${seconds}`);
var time = setInterval(() => {
    const time = new Date();
    const hours = time.getHours();
    const minutes = time.getMinutes();
    const seconds = time.getSeconds();
    pClock.textContent = `${hours}:${minutes}:${seconds}`;
}, 1000);

window.addEventListener("keydown", (e) => {
  if (e.altKey && e.key === "w") {
    clearInterval(time);
  }
});