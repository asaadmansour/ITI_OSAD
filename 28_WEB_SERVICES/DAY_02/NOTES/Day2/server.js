/**
 * server.js - Advanced Version
 * 
 * We add a 'context' function here. Context is an object that is passed to 
 * every single resolver. It's usually used for:
 * 1. Authentication (User info)
 * 2. Database connections
 * 3. Logging
 */

const express = require('express');
const { ApolloServer } = require('@apollo/server');
const { expressMiddleware } = require('@apollo/server/express4');
const cors = require('cors');

const typeDefs = require('./schema');
const resolvers = require('./resolvers');
const { users } = require('./data');

async function startServer() {
  const app = express();
  const PORT = 4000;

  const server = new ApolloServer({
    typeDefs,
    resolvers,
  });

  await server.start();

  app.use(cors());
  app.use(express.json());

  // Root route
  app.get('/', (req, res) => {
    res.send(`
      <h1>Advanced GraphQL Educational Project</h1>
      <p><b>Tutorial Links:</b></p>
      <ul>
        <li>GraphQL Sandbox: <a href="/graphql">/graphql</a></li>
        <li>REST Comparison: <a href="/users">/users</a></li>
      </ul>
      <p><i>Check terminal logs to see field resolvers in action!</i></p>
    `);
  });

  // REST endpoint (now returning users with their roles)
  app.get('/users', (req, res) => {
    res.json(users);
  });

  // GraphQL endpoint
  app.use(
    '/graphql',
    expressMiddleware(server),
  );

  app.listen(PORT, () => {
    console.log(`🚀 Server ready at http://localhost:${PORT}/graphql`);
    console.log(`📡 REST endpoint at http://localhost:${PORT}/users`);
    
    console.log(`
--- ADVANCED SAMPLE QUERIES ---

1. FETCH USERS WITH THEIR POSTS (RELATIONSHIP):
query {
  getAllUsers {
    name
    role
    posts {
      title
    }
  }
}

2. CREATE USER WITH INPUT OBJECT:
mutation {
  createUser(input: { 
    name: "New Teacher", 
    email: "teacher@school.com", 
    role: TEACHER 
  }) {
    id
    name
    role
  }
}

3. FILTERING BY ENUM:
query {
  getAllUsers(role: TEACHER) {
    name
  }
}

    `);
  });
}

startServer();
