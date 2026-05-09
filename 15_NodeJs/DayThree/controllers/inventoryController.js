const inventoryService = require("../services/inventoryService");

function getAllProducts(req, res) {
  try {
    const products = inventoryService.getAll();
    res.status(200).json(products);
  } catch (err) {
    res.status(404).json("Not Found");
  }
}
function getProductById(req, res) {
  const item = inventoryService.getItemById(req.id);
  try {
    if (!item) {
      res.status(404).json({ message: "Not Found" });
      return;
    }
    res.status(200).json(item);
  } catch (error) {
    res.status(500).json({ error: error });
  }
}
function createProduct(req, res) {
  const newProduct = inventoryService.createNewItem(req.body);
  try {
    if (!newProduct) {
      res.status(404).json("Not Found");
      return;
    }
    res.status(200).json("Product is Added!");
  } catch (err) {
    res.status(500).json(err);
  }
}
function deleteProduct(req, res) {
  try {
    const isDeleted = inventoryService.deleteById(req.id);
    if (!isDeleted) {
      res.status(500).json("Error: Error Deleting The Product");
      return;
    }
    res.status(200).json("Deleted!");
  } catch (err) {
    res.status(500).json(err);
  }
}
function updateProduct(req, res) {
  try {
    const isUpdated = inventoryService.updateById(req.id, req.body);
    if (!isUpdated) {
      res.status(500).json("Error: Error Updating The Product");
      return;
    }
    res.status(200).json("Updated!");
  } catch (err) {
    res.status(500).json(err);
  }
}
function renderProducts(req, res) {
  const products = inventoryService.getAll();
  res.render("index", {
    title: "Inventory",
    message: "Product List",
    products,
  });
}
module.exports = {
  getAllProducts,
  getProductById,
  createProduct,
  deleteProduct,
  updateProduct,
  renderProducts,
};
