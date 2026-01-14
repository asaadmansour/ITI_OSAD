import Shape from "./Shape.js";
class Circle extends Shape {
  radius;
  static count = 0;
  constructor(radius) {
    super();
    this.radius = radius;
    Circle.count++;
  }
  calculateArea() {
    return Math.PI * Math.pow(this.radius, 2);
  }
  calculatePerimeter() {
    return 2 * Math.PI * this.radius;
  }
  static instancesCount() {
    return Circle.count;
  }
}
export default Circle;
