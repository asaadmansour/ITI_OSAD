/**
 * data.js - Advanced Version
 * 
 * We now have two entities: Users and Posts.
 * This allows us to demonstrate Relationships (User <-> Post).
 */

const users = [
  { id: "1", name: "John Doe", email: "john@example.com", role: "ADMIN" },
  { id: "2", name: "Jane Smith", email: "jane@example.com", role: "TEACHER" },
  { id: "3", name: "Alice Johnson", email: "alice@example.com", role: "STUDENT" },
];

const posts = [
  { id: "101", title: "Introduction to GraphQL", content: "GraphQL is awesome!", authorId: "1" },
  { id: "102", title: "Advanced Resolvers", content: "Resolvers are the heart of GraphQL.", authorId: "1" },
  { id: "103", title: "Teaching with Node.js", content: "Node.js is great for backends.", authorId: "2" },
];

module.exports = { users, posts };
