/**
 * resolvers.js - Advanced Version
 * 
 * ADVANCED CONCEPTS:
 * 1. FIELD RESOLVERS: Handling relationships (e.g., how to find posts for a specific user).
 * 2. N+1 PROBLEM: Discussion in comments about fetching efficiency.
 */

let { users, posts } = require('./data');
const { GraphQLError } = require('graphql');

const resolvers = {
  // --- QUERIES ---
  Query: {
    getAllUsers: (parent, args, context) => {
      // ADVANCED: Optional filtering by argument
      if (args.role) {
        return users.filter(user => user.role === args.role);
      }
      return users;
    },

    getUserById: (parent, { id }) => users.find(u => u.id === id),

    getAllPosts: () => posts,
    
    getPostById: (parent, { id }) => posts.find(p => p.id === id),
  },

  // --- MUTATIONS ---
  Mutation: {
    createUser: (parent, { input }) => {
      // Checking if email already exists
      if (users.some(u => u.email === input.email)) {
        throw new GraphQLError('Email already in use', {
          extensions: { code: 'BAD_USER_INPUT' }
        });
      }

      const newUser = {
        id: String(users.length + 1),
        ...input
      };
      users.push(newUser);
      return newUser;
    },

    deleteUser: (parent, { id }) => {
      const index = users.findIndex(u => u.id === id);
      if (index === -1) return null;
      return users.splice(index, 1)[0];
    }
  },

  /**
   * --- FIELD RESOLVERS (Relationships) ---
   * These are specialized resolvers for fields that are not part of the flat data.
   * 
   * When a client asks for:
   * query {
   *   getUserById(id: "1") {
   *     name
   *     posts { title }  <-- This triggers the 'User.posts' resolver
   *   }
   * }
   */
  User: {
    // 'parent' here is the User object found by the Query resolver
    posts: (parent) => {
      console.log(`Fetching posts for user: ${parent.name}`);
      return posts.filter(post => post.authorId === parent.id);
    }
  },

  Post: {
    // Finding the author of a post
    author: (parent) => {
      console.log(`Fetching author for post: ${parent.title}`);
      return users.find(user => user.id === parent.authorId);
    }
  }

  /**
   * EDUCATIONAL NOTE: The N+1 Problem
   * 
   * If you fetch 10 users and ask for their posts:
   * 1. Query.getAllUsers runs (1 call)
   * 2. User.posts runs for EACH of the 10 users (10 calls)
   * Total = 11 calls for 10 users. 
   * 
   * In a real database, this is inefficient. Tools like 'DataLoader' are used 
   * in advanced GraphQL to batch these 10 calls into 1.
   */
};

module.exports = resolvers;
