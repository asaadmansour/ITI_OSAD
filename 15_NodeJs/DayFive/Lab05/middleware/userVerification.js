const Joi = require('joi');
// const joi = require('joi');

const schema = Joi.object({
  username: Joi.string().alphanum().min(3).max(30).required(),
  password: Joi.string().min(5).required(),
  firstName: Joi.string().min(5).max(15).required(),
  lastName: Joi.string().min(5).max(15).required(),
  dob: Joi.date(),
  createdAt: Joi.date(),
  updatedAt: Joi.date(),
  lastLogin: Joi.date()
});
function userVerification(req, res, next) {
  const {error} = schema.validate(req.body);
  if (error) return res.status(400).json({error: error.details[0].message});
  next();
}
module.exports = userVerification;
