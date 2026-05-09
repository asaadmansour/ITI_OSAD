function swap(...x) {
  return [[...x][1], [...x][0]];
}
// [x,y] = [y,x];
console.log(swap(1, 2));
