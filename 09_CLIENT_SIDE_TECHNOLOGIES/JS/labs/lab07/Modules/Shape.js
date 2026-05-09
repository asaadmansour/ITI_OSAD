class Shape {
  constructor() {
    if (this.constructor == Shape) throw "error";
  }
  calculateArea() {}
  calculatePerimeter() {}
  toString() {
    return (
      "Area " + this.calculateArea() + " Perimeter " + this.calculatePerimeter()
    );
  }
  instancesCount() {}
}
export default Shape;
