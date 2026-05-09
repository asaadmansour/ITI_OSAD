// b- Display all instructors with salaries greater than 4000
// (only show firstName and salary)
db.instructors.find({ salary: { $gt: 4000 } }, { firstName: 1, salary: 1 });
// c- Display all instructors with ages less than or equal 25.
db.instructors.find({ age: { $lte: 25 } });
// d- Display all instructors with city mansoura and sreet number
// 10 or 14 only display (firstname,address,salary).
db.instructors.find(
  {
    $and: [
      { "address.city": "mansoura" },
      { $or: [{ "address.street": 10 }, { "address.street": 14 }] },
    ],
  },
  { firstName: 1, address: 1, salary: 1 },
);
// e- Display all instructors that have js and jquery in their courses
// (both of them not one of them).
db.instructors.find({ courses: { $all: ["js", "jquery"] } });
// f- Display number of courses for each instructor and display
// first name with number of courses.
db.instructors.find().forEach((inst) => {
  if (inst) {
    print(inst.firstName, inst.courses.length);
  }
});

db.instructors
  .find({ firstName: { $exists: 1 }, lastName: { $exists: 1 } })
  .sort({ firstName: 1, lastName: -1 })
  .forEach((inst) => {
    print("Full name: " + inst.firstName, inst.lastName + ",Age: " + inst.age);
  });
// Delete instructor with first name “ebtesam” and has only 5xcourses in courses array
db.instructors.deleteOne({
  firstName: "ebtesam",
  courses: { $size: 5 },
});
// /Add active property to all instructors and set its value to
// true.
db.instructors.updateMany({}, { $set: { active: true } });
// j- Change “EF” course to “jquery” for “mazen
// mohammed” instructor (without knowing EF Index in courses
// array)
db.instructors.updateOne(
  {
    firstName: "mazen",
    lastName: "mohammed",
    courses: "EF",
  },
  {
    $set: { "courses.$": "jquery" },
  },
);
// Add jquery course for “noha hesham”.
db.instructors.updateOne(
  { firstName: "noha", lastName: "hesham" },
  { $addToSet: { courses: "jquery" } },
);
//
db.instructors.updateOne(
  { firstName: "ahmed", lastName: "mohammed" },
  { $unset: { courses: "" } },
);

// Decrease salary by 500 for all instructors that has only 3
// courses in their list ($inc)
db.instructors.updateMany(
  { courses: { $size: 3 } },
  { $inc: { salary: -500 } },
);
// Rename address field for all instructors to fullAddress.
db.instructors.updateMany({}, { $rename: { address: "fullAddress" } });
// Change street number for noha hesham to 20
db.instructors.updateOne(
  { firstName: "noha", lastName: "hesham" },
  { $set: { "address.street": 20 } },
);
