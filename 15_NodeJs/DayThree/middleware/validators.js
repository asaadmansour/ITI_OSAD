function validateId(req, res, next) {
  const id = Number(req.params.id);

  if (!Number.isInteger(id) || id < 0) {
    return res.status(400).json({ message: "Invalid Id" });
  }
  req.id = id;
  next();
}
function validateCreateItem(req, res, next) {
  const item = req.body || {};
  if (
    !item.itemName ||
    typeof item.itemName !== "string" ||
    item.itemName.length < 1 ||
    item.itemName.length > 100
  ) {
    return res.status(400).json({ message: "Invalid itemName" });
  }
  if (
    item.quantity !== undefined &&
    (!Number.isInteger(item.quantity) || item.quantity < 0)
  ) {
    return res.status(400).json({ message: "Invalid quantity" });
  }
  if (
    item.category !== undefined &&
    (typeof item.category !== "string" || item.category.length > 50)
  ) {
    return res.status(400).json({ message: "Invalid category" });
  }
  req.newItem = {
    itemName: item.itemName,
    quantity: item.quantity ?? 1,
    category: item.category ?? "general",
  };
  next();
}
module.exports = { validateId, validateCreateItem };
