var inp = document.querySelector("#Answer");
inp.setAttribute("disabled", "");
function EnterNumber(num) {
  inp.value += num;
}
function EnterOperator(operator) {
  if(!isLastElementOperator())
    inp.value += operator;
}
function EnterClear() {
  inp.value = "";
}
function  EnterEqual() {
  inp.value = eval(inp.value);
}
function isLastElementOperator() {
  if(inp.value.slice(-1) === "+" || inp.value.slice(-1) === "-" || inp.value.slice(-1) === "*"  || inp.value.slice(-1) === "/"  )
    return true;
  return false;
}