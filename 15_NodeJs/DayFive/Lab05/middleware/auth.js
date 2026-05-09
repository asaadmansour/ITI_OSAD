const process = require('node:process');
const jwt = require('jsonwebtoken');
const CustomError = require('../helpers/CustomError');
const Users = require('../model/users');

const SECRETJWT = process.env.SECRETJWT || 'asaadabcdefgasabce';
async function authMiddleWare(req, res, next) {
  const {authorization} = req.headers;
  if (!authorization) throw new CustomError({statusCode: 401, message: 'No authorization header provided'});
  try {
    const payload = jwt.verify(authorization, SECRETJWT);
    // console.log(payload);
    const user = await Users.findById(payload.userId).exec();
    // console.log(user);
    if (!user) throw new CustomError({statusCode: 401, message: 'User not found'});
    req.user = user;
    next();
  } catch (err) {
    throw new CustomError({statusCode: 401, message: 'Invalid or expired token'});
  }
}
module.exports = {authMiddleWare};
