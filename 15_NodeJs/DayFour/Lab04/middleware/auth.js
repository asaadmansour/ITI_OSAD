const Products = require('../model/products');

const checkProductOwnership = async (req, res, next) => {
  try {
    const productId = req.params.id;
    const product = await Products.findById(productId);

    if (!product) {
      return res.status(404).json({error: 'Product not found'});
    }

    const productOwnerId = product.owner.toString();
    const userId = req.body.id;

    if (productOwnerId !== userId) {
      return res.status(403).json({error: 'Not allowed. You are not the owner of this product.'});
    }
    next();
  } catch (error) {
    return res.status(500).json({error: 'Server error'});
  }
};

module.exports = {checkProductOwnership};
