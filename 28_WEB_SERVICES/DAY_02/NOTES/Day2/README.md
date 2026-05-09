# Advanced GraphQL Educational Project

This project has been upgraded to cover advanced GraphQL topics. It's designed to show how GraphQL handles real-world complexity like relationships and data structures.

## Advanced Topics Covered

### 1. Enums
- Restricting fields (like `UserRole`) to specific allowed values (`ADMIN`, `TEACHER`, `STUDENT`).
- How to use Enums in Queries and Mutations.

### 2. Relationships (The Graph)
- **One-to-Many**: A `User` has a list of `Posts`.
- **Many-to-One**: A `Post` has an `author` (`User`).
- Explained via **Field Resolvers** in `resolvers.js`.

### 3. Input Types
- Using `input` objects in mutations instead of flat arguments.
- Benefits for API maintenance and clean code.

### 4. Error Handling
- Using `GraphQLError` to return descriptive errors and status codes (e.g., duplicate emails).

### 5. The N+1 Problem
- Explained in the `resolvers.js` comments.
- Shows how GraphQL execution can lead to redundant database calls and how to spot them.

## Setup & Running

1. **Install**: `npm install`
2. **Start**: `npm start`
3. **Explore**:
   - [http://localhost:4000/graphql](http://localhost:4000/graphql) - GraphQL Sandbox.
   - [http://localhost:4000/users](http://localhost:4000/users) - REST comparison.

## Testing Advanced Features

### Testing Relationships
Run this query and watch the terminal logs to see the "Field Resolvers" firing:
```graphql
query {
  getAllUsers {
    name
    posts {
      title
      content
    }
  }
}
```

### Testing Input Objects
```graphql
mutation {
  createUser(input: { 
    name: "Dr. Smith", 
    email: "smith@uni.edu", 
    role: TEACHER 
  }) {
    id
    name
  }
}
```
