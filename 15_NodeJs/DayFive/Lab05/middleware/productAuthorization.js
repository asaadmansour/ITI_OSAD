const CustomError = require('../helpers/CustomError');
const Products = require('../model/products');

const canEditProduct = async (req, res, next) => {
  const {id} = req.params;
  if (req.user.role === 'admin') return next();
  const product = await Products.findById(id);
  if (!product) {
    return next(new CustomError({statusCode: 404, message: 'Product not found'}));
  }
  if (product.owner && product.owner.toString() === req.user._id.toString()) {
    return next();
  }

  next(new CustomError({statusCode: 403, message: 'Not authorized to edit this product'}));
};

module.exports = canEditProduct;
