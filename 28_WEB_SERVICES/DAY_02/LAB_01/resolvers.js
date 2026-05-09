const { users, comments, articles } = require("./data");
const resolvers = {
  Query: {
    users: (parent, args, context) => users,
    user: (parent, args, context) => {
      return users.find((u) => u.id == args.id);
    },
    articles: (parent, args, context) => articles,
    article: (parent, args, context) => {
      return articles.find((a) => a.id == args.id);
    },
    comments: (parent, args, context) => comments,
    comment: (parent, args, context) => {
      return comments.find((c) => c.id == args.id);
    },
  },

  Mutation: {
    createUser: (parent, args, context) => {
      const user = args.data;
      if (!user) return;
      users.push(user);
      return user;
    },
    createArticle: () => {
      const article = args.data;
      if (!article) return;
      articles.push(article);
      return article;
    },
    createComment: () => {
      const comment = args.data;
      if (!comment) return;
      comments.push(comment);
      return comment;
    },
  },
};

module.exports = resolvers;
