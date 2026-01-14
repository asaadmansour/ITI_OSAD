import Shape from "./Shape.js";
import Square from "./Square.js";
import Circle from "./Circle.js";
import Rectangle from "./Rectangle.js";

// let sh = new Shape();
let sq = new Square(10);
let sqq = new Square(10);
let sqqq = new Square(10);
let c1 = new Circle(10);
let c = new Circle(10);
let rec = new Rectangle(10, 20);

console.log(c.toString());
console.log(sq.toString());
console.log(rec.toString());
console.log(Square.instancesCount());
console.log(Circle.instancesCount());
console.log(Rectangle.instancesCount());
