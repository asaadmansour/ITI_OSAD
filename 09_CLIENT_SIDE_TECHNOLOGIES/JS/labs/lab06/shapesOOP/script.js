class Shape {
    constructor() {
        if(this.constructor == Shape)
            throw("error");
    }
    calculateArea(){}
    calculatePerimeter(){}
    toString() {
        return "Area " + this.calculateArea() + " Perimeter " + this.calculatePerimeter()
    }
    instancesCount() {}
}
class Circle extends Shape {
    radius;
    static count = 0;
    constructor(radius) {
        super();
        this.radius = radius;
        Circle.count++;
    }
    calculateArea() {
        return Math.PI * Math.pow(this.radius,2);
    }
    calculatePerimeter() {
        return 2 * Math.PI * this.radius;
    }
    static instancesCount() {
        return Circle.count;
    }
}
class Square extends Shape {
    static instance = null;
    static count = 0;
    side;
    constructor(side) {
        if(Square.instance !== null) {
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
class Rectangle extends Shape {
    static count = 0;
    static instance = null;
    #width;
    #length;
    constructor(width,length) {
        if(Rectangle.instance !== null) {
            return Rectangle.instance;
        }
        super();
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
// let sh = new Shape();
let sq = new Square(10);
let sqq = new Square(10);
let sqqq = new Square(10);
let c1 = new Circle(10);
let c = new Circle(10);
let rec = new Rectangle(10,20);

console.log(c.toString());
console.log(sq.toString());
console.log(rec.toString());
console.log(Square.instancesCount());
console.log(Circle.instancesCount());
console.log(Rectangle.instancesCount());
