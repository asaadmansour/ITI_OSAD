let fruits = ["banana", "strawberry", "orange", "apple", "mango"];
console.log(fruits.every((x) => !isFinite(x)));
console.log(fruits.some((x) => x.startsWith("a")));
console.log(fruits.filter((x) => x.startsWith("b") || x.startsWith("s")));
console.log(fruits.map((x) => `I like ${x}`));
