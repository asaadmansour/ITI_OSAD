const app = require("./app.js");
const { ApolloServer } = require("@apollo/server");
const { expressMiddleware } = require("@apollo/server/express4");
const fs = require("fs");
const resolvers = require("./resolvers");

const typeDefs = fs.readFileSync("./schema.gql", "utf8");
const PORT = 3001;
const server = new ApolloServer({ typeDefs, resolvers });

async function start() {
  await server.start();
  app.use("/graphql", expressMiddleware(server));
  app.listen(PORT, () =>
    console.log(`App running on http://localhost:${PORT}/graphql`),
  );
}

start();
