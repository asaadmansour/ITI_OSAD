const CustomError = require('../helpers/CustomError');

const canEdit = async (req, res, next) => {
  const {id} = req.params;
  if (req.user.role === 'admin') return next();
  if (id === req.user._id.toString()) return next();
  next(new CustomError({statusCode: 403, message: 'Not authorized'}));
};

module.exports = canEdit;
