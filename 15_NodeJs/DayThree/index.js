const express = require("express");
const inventoryController = require("./controllers/inventoryController.js");
const validators = require("./middleware/validators.js");
const app = express();

app.use(express.json());
app.use(express.static("public"));
app.set("view engine", "pug");

app.get("/inventory", inventoryController.renderProducts);
app.get(
  "/inventory/:id",
  validators.validateId,
  inventoryController.getProductById,
);
app.post(
  "/inventory",
  validators.validateCreateItem,
  inventoryController.createProduct,
);
app.delete(
  "/inventory/:id",
  validators.validateId,
  inventoryController.deleteProduct,
);
app.patch(
  "/inventory/:id",
  validators.validateId,
  inventoryController.updateProduct,
);
app.listen(3000, () => {
  console.log("Server running on port 3000");
});
