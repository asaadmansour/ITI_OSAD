/**
 * schema.js - Advanced Version
 * 
 * ADVANCED TOPICS:
 * 1. ENUMS: Restricting a field to a specific set of values.
 * 2. RELATIONSHIPS: Connecting different types (User -> Posts).
 * 3. INPUT TYPES: Grouping mutation arguments into a single object for cleaner API.
 * 4. NULLABILITY: Using '!' to mark fields as required.
 */

// The gql tag is optional in modern Apollo, we use #graphql for syntax highlighting
const typeDefs = `#graphql

  # 1. ENUMS
  # Limits the 'role' field to these three specific strings.
  enum UserRole {
    ADMIN
    TEACHER
    STUDENT
  }

  # 2. TYPES WITH RELATIONSHIPS
  type User {
    id: ID!
    name: String!
    email: String!
    role: UserRole!
    
    # RELATIONAL FIELD: A user can have many posts.
    # This demonstrates the 'Graph' part of GraphQL.
    posts: [Post!]
  }

  type Post {
    id: ID!
    title: String!
    content: String!
    
    # RELATIONAL FIELD: Every post has exactly one author.
    author: User!
  }

  # 3. INPUT TYPES
  # Instead of having 5 separate arguments in a mutation, we use one Input object.
  # This makes the API much easier to maintain and extend.
  input CreateUserInput {
    name: String!
    email: String!
    role: UserRole = STUDENT # Default value
  }

  # 4. OPERATIONS
  type Query {
    # Fetching with filtering
    getAllUsers(role: UserRole): [User]
    getUserById(id: ID!): User
    
    getAllPosts: [Post]
    getPostById(id: ID!): Post
  }

  type Mutation {
    # Using the Input object defined above
    createUser(input: CreateUserInput!): User
    
    deleteUser(id: ID!): User
  }
`;

module.exports = typeDefs;
