let users = [
  {
    id: "1",
    fullName: "Ahmed Hassan",
    email: "ahmed@example.com",
    dob: "1998-05-12",
  },
  {
    id: "2",
    fullName: "Sara Ali",
    email: "sara@example.com",
    dob: "2000-11-03",
  },
  {
    id: "3",
    fullName: "Omar Khaled",
    email: "omar@example.com",
    dob: "1995-02-20",
  },
];

let articles = [
  {
    id: "1",
    title: "Introduction to GraphQL",
    content: "GraphQL is a query language for APIs...",
    author: users[0],
  },
  {
    id: "2",
    title: "Why React is Popular",
    content: "React is a powerful library for building UIs...",
    author: users[1],
  },
  {
    id: "3",
    title: "Understanding Node.js",
    content: "Node.js allows JavaScript to run on the server...",
    author: users[2],
  },
];

let comments = [
  {
    id: "1",
    content: "Great article!",
    article: articles[0],
  },
  {
    id: "2",
    content: "Very helpful, thanks!",
    article: articles[0],
  },
  {
    id: "3",
    content: "I learned a lot from this.",
    article: articles[1],
  },
  {
    id: "4",
    content: "Nice explanation!",
    article: articles[2],
  },
];
module.exports = { users, articles, comments };
