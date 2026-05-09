import Shape from "./Shape.js";
class Square extends Shape {
  static instance = null;
  static count = 0;
  side;
  constructor(side) {
    if (Square.instance !== null) {
      return Square.instance;
    }
    super();
    this.side = side;
    Square.count++;
    Square.instance = this;
  }
  calculateArea() {
    return this.side * this.side;
  }
  calculatePerimeter() {
    return 4 * this.side;
  }
  static instancesCount() {
    return Square.count;
  }
}
export default Square;
