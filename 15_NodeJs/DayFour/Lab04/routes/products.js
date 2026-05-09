const express = require('express');
const {productsController} = require('../controllers');
const {checkProductOwnership} = require('../middleware');

const router = express.Router();

router.get('/', async (req, res) => {
  const products = await productsController.get(req.query);
  res.json(products);
});
router.get('/:id/products', async (req, res) => {
  const {id} = req.params;
  const products = await productsController.getProductsForUserById(id);
  if (!products) return;
  res.json(products);
});
router.post('/', async (req, res) => {
  const {body} = req;
  const product = await productsController.set(body);
  res.json(product);
});
router.delete('/:id', checkProductOwnership, async (req, res) => {
  const {id} = req.params;
  const deletedProuct = await productsController.deleteProduct(id);
  res.json(deletedProuct);
});
router.patch('/:id', checkProductOwnership, async (req, res) => {
  const {id} = req.params;
  const {body} = req;
  const updatedProduct = await productsController.update(id, body);
  res.json(updatedProduct);
});
router.patch('/:id/stock', checkProductOwnership, async (req, res) => {
  const {id} = req.params;
  const {operation, quantity} = req.body;
  if (operation === 'restock') {
    const updatedProduct = await productsController.restock(id, quantity);
    res.json(updatedProduct);
    return;
  }
  if (operation === 'destock') {
    const updatedProduct = await productsController.destock(id, quantity);
    res.json(updatedProduct);
  }
});
module.exports = router;
