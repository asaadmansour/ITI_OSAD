const express = require("express");
const app = express();

app.use(express.json());

const students = [
  { id: 1, name: "Asaad", Age: 22 },
  { id: 2, name: "Omar", Age: 21 },
];

app.get("/students", (req, res) => {
  res.status(200).json(students);
});
app.get("/students/:id", (req, res) => {
  const { id } = req.params;
  const student = students.find((student) => student.id == id);
  if (!student) return res.status(404).json({ message: "Student not found" });
  res.status(200).json(student);
});
app.post("/students", (req, res) => {
  students.unshift(req.body);
  res.status(201).json(req.body);
});
app.patch("/students/:id", (req, res) => {
  const { id } = req.params;
  const student = students.find((student) => student.id == id);
  if (!student) return res.status(404).json({ message: "Student not found" });
  Object.assign(student, req.body);
  res.status(200).json(student);
});

app.delete("/students/:id", (req, res) => {
  const { id } = req.params;
  const index = students.findIndex((student) => student.id == id);
  if (index == -1)
    return res.status(404).json({ message: "Student not found" });
  const deleted = students.splice(index, 1);
  return res.status(200).json(deleted[0]);
});

/////////////////
const courses = [
  { id: 1, title: "nodejs" },
  { id: 2, title: "web services" },
  { id: 3, title: "java" },
];
app.get("/courses", (req, res) => {
  res.status(200).json(courses);
});
app.get("/courses/:id", (req, res) => {
  const { id } = req.params;
  const course = courses.find((course) => course.id == id);
  if (!course) return res.status(404).json({ message: "Course not found" });
  res.status(200).json(course);
});
app.post("/courses", (req, res) => {
  courses.unshift(req.body);
  res.status(201).json(req.body);
});
app.patch("/courses/:id", (req, res) => {
  const { id } = req.params;
  const course = courses.find((course) => course.id == id);
  if (!course) return res.status(404).json({ message: "Course not found" });
  Object.assign(course, req.body);
  res.status(200).json(course);
});

app.delete("/courses/:id", (req, res) => {
  const { id } = req.params;
  const index = courses.findIndex((course) => course.id == id);
  if (index == -1) return res.status(404).json({ message: "Course not found" });
  const deleted = courses.splice(index, 1);
  return res.status(200).json(deleted[0]);
});

module.exports = app;
