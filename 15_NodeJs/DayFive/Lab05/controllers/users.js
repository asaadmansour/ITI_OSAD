const CustomError = require('../helpers/CustomError');
const Users = require('../model/users');

const get = async () => {
  const allUsers = await Users.find({}, {_id: 1, firstName: 1});
  return allUsers;
};
const getById = async (id) => {
  const user = await Users.findById(id);
  if (!user) return;
  return user;
};
const create = async (data) => {
  try {
    const user = new Users(data);
    const savedUser = await Users.create(user);
    return savedUser;
  } catch (err) {
    console.log('Error:', err);
    return err;
  }
};
const validate = async (data) => {
  const user = await Users.findOne({username: data.username});
  console.log(user);
  // debugger;
  if (!user)
    throw new CustomError({statusCode: 401, code: 'AUTH_ERROR', message: 'User name or password is not correct'});
  const isValidPassword = user.validatePw(data.password);
  console.log(data.password);
  console.log(isValidPassword);
  if (!isValidPassword)
    throw new CustomError({statusCode: 401, code: 'AUTH_ERROR', message: 'User name or password is not correct'});
  const jwt = user.generateJwt();
  user.lastLogin = Date.now();
  await user.save();
  return jwt;
};
const update = async (id, updates) => {
  try {
    const user = await Users.findById(id);
    if (!user) return;
    // console.log(updates);
    Object.keys(updates).forEach((update) => {
      // console.log(update);
      // console.log(updates);
      // console.log(updates[update]);
      user[update] = updates[update];
    });
    user.updatedAt = Date.now();
    await user.save();
    return user;
  } catch (err) {
    console.log(err);
    throw err;
  }
};
const deleteUser = async (id) => {
  try {
    const user = Users.findByIdAndDelete(id);
    if (!user) return;
    return user;
  } catch (err) {
    console.log(err);
    throw err;
  }
};
module.exports = {get, create, update, deleteUser, getById, validate};
