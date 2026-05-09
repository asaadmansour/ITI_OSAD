const process = require('node:process');
const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');
const mongoose = require('mongoose');

const SECRETJWT = process.env.SECRETJWT || 'asaadabcdefgasabce';
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
  role: {
    type: String
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
usersSchema.pre('save', function () {
  if (this.isModified('password')) {
    this.password = bcrypt.hashSync(this.password, 10);
  }
});

usersSchema.methods.validatePw = function (password) {
  return bcrypt.compareSync(password, this.password);
};

usersSchema.methods.generateJwt = function () {
  return jwt.sign({username: this.username, userId: this._id}, SECRETJWT);
};
const Users = mongoose.model('users', usersSchema);

module.exports = Users;
