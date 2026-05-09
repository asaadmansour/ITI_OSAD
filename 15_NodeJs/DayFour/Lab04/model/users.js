const mongoose = require('mongoose');
// const {helpers} = require('../helpers');

const usersSchema = new mongoose.Schema({
  username: {
    type: String,
    required: true,
    unique: true,
    minLength: 8
  },
  firstName: {
    type: String,
    minLength: 3,
    maxLength: 15,
    required: true
  },
  lastName: {
    type: String,
    minLength: 3,
    maxLength: 15,
    required: true
  },
  password: {
    type: String,
    minLength: 5,
    required: true
  },
  dob: {
    type: Date
  },
  createdAt: {
    type: Date,
    default: Date.now
  },
  updatedAt: {
    type: Date,
    default: Date.now
  },
  lastLogin: {
    type: Date,
    default: null
  }
});
const Users = mongoose.model('users', usersSchema);

module.exports = Users;
