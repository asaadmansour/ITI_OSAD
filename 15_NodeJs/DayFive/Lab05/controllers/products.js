const Products = require('../model/products');
// const Users = require('../model/users');

const get = async (query) => {
  const {limit = 10, skip = 0, status} = query;
  const filter = {};
  if (status) {
    if (status === 'out_of_stock') filter.quantity = 0;
    else if (status === 'low_stock') filter.quantity = {$gt: 0, $lte: 2};
    else if (status === 'available') filter.quantity = {$gt: 2};
  }
  return await Products.find(filter).limit(Number(limit)).skip(Number(skip));
};
const getProductsForUserById = async (id) => {
  return await Products.find({owner: id});
};

const set = async (data) => {
  const product = new Products(data);
  const savedProduct = await Products.create(product);
  if (!savedProduct) return;
  return savedProduct;
};
const update = async (id, updates) => {
  const product = await Products.findById(id);
  Object.keys(updates).forEach((update) => {
    product[update] = updates[update];
  });
  product.updatedAt = Date.now();
  await product.save();

  return product;
};
const deleteProduct = async (id) => {
  const deletedProuct = await Products.findByIdAndDelete(id);
  if (!deletedProuct) return;
  return deletedProuct;
};
const restock = async (id, quantity) => {
  const product = await Products.findById(id);
  if (!product) return;
  product.quantity += quantity;
  await product.save();
  return product;
};
const destock = async (id, quantity) => {
  const product = await Products.findById(id);
  if (!product) return;
  if (product.quantity < quantity) {
    return;
  }
  product.quantity -= quantity;
  await product.save();
  return product;
};
module.exports = {get, set, deleteProduct, getProductsForUserById, update, restock, destock};
