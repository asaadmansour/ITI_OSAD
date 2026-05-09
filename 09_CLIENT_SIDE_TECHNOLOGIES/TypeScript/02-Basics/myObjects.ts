// function createUser({
//   userName,
//   phone,
// }: {
//   userName: string;
//   phone: string;
// }): User {
//   return new User(userName, phone);
// }
// export {};
// better to do
type User = {
  name: string;
  phone: number;
  age: number;
};
type User2 = {
  readonly _id: string; // readonly here is to make this unchangable after assignement
  name2: string;
  phone2: number;
  age2: number;
  creditCardDetails?: number; // to mark this field as optional we use ?
};
let user2: User2 = { _id: "1", name2: "a", phone2: 1, age2: 1 };
user2.age2 = 11;
// user2._id = asaad;  error here cannot assign value to read only variable
function createUser(user: User): User {
  return user;
}
let user: User = createUser({ name: "asaad", phone: 10, age: 22 });
console.log(user);
export {};
// we can combine 1 or more defined types to create a new type
type User3 = User & User2;
let user3: User3 = {
  name: "asaad",
  phone: 10,
  age: 22,
  _id: "1",
  name2: "a",
  phone2: 1,
  age2: 1,
  creditCardDetails: 1,
};
