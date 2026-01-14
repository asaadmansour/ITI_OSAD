import Shape from "./Shape.js";
class Rectangle extends Shape {
  static count = 0;
  static instance = null;
  #width;
  #length;
  constructor(width, length) {
    super();
    if (Rectangle.instance !== null) {
      return Rectangle.instance;
    }
    this.#width = width;
    this.#length = length;
    Rectangle.count++;
    Rectangle.instance = this;
  }
  calculateArea() {
    return this.#width * this.#length;
  }
  calculatePerimeter() {
    return 2 * (this.#length + this.#width);
  }
  static instancesCount() {
    return Rectangle.count;
  }
}
export default Rectangle;
