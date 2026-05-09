class Book {
    title;
    noOfChapters;
    author;
    noOfPages;
    publisher;
    noOfCopies;
    type;
    
    constructor(title, noOfChapters, author, noOfPages, publisher, noOfCopies, type) {
        this.title = title;
        this.noOfChapters = noOfChapters;
        this.author = author;
        this.noOfPages = noOfPages;
        this.publisher = publisher;
        this.noOfCopies = noOfCopies;
        this.type = type;
    }
}
class Box {
    #content;
    height;
    width;
    length;
    numofBooks;
    volume;
    material;
    
    constructor(height, width, length, material) {
        this.#content = [];
        this.height = height;
        this.width = width;
        this.length = length;
        this.numofBooks = 0;
        this.volume = height * width * length;
        this.material = material;
    }
    
    addItem(item) {
        if(item instanceof Book) {
            this.#content.push(item);
            this.numofBooks++;
        }
    }
    deleteBook(title) {
        for (let i = 0; i < this.#content.length; i++) {
            if (this.#content[i].title === title) {
                this.#content.splice(i, 1);
                this.numofBooks--;
                break;
            }
        }
    }
    toString() {
        return "Height " + this.height + " Width " + this.width + " Volume " + this.volume;
    }
    valueOf() {
        return this.numofBooks;
    }
}
let book1 = new Book("JavaScript Guide", 12, "John Doe", 350, "O'Reilly", 100, "Programming");
let book2 = new Book("Python Basics", 8, "Jane Smith", 200, "Manning", 50, "Programming");
let book3 = new Book("Clean Code", 15, "Robert Martin", 450, "Pearson", 200, "Software");

let box1 = new Box(30, 20, 25, "Cardboard");
let box2 = new Box(40, 30, 35, "Wood");
// box1.content= "asaad";
// box1.#content= "asaad";
console.log(box1.content) 
console.log(box1)


box1.addItem(book1);
box1.addItem(book2);

box2.addItem(book3);

console.log("Box 1:", box1.toString());
console.log("Box 1 books:", box1.numofBooks);

console.log("Box 2:", box2.toString());
console.log("Box 2 books:", box2.numofBooks);


console.log("Box1 + Box2 books:", box1 + box2);  
console.log("Box1 > Box2?", box1 > box2);        


box1.deleteBook("JavaScript Guide");
console.log("After delete, Box 1 books:", box1.numofBooks);  