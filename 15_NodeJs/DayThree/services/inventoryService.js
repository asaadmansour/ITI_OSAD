const fs = require("fs");
const path = require("path");
const save = require("../model/save");
const filePath = path.join(__dirname, "../model/inventory.json");

function loadData() {
  const contentString = fs.readFileSync(filePath, "utf-8");
  const allItems = JSON.parse(contentString);
  return allItems.filter((el) => !el.isDeleted);
}
function generateId(data) {
  if (data.length === 0) return 1;
  const lastId = parseInt(data[data.length - 1].id);
  return lastId + 1;
}
function getAll() {
  return loadData();
}
function getItemById(id) {
  const items = loadData();
  return items.find((el) => el.id === id && !el.isDeleted);
}
function createNewItem(itemData) {
  const items = loadData();
  const newItem = {
    id: generateId(items),
    itemName: itemData.itemName,
    quantity: itemData.quantity || 1,
    category: itemData.category || "general",
    isDeleted: false,
  };
  items.push(newItem);
  save(items, filePath);
  return newItem;
}
function deleteById(id) {
  const items = loadData();
  const item = items.find((el) => el.id === id && !el.isDeleted);
  if(!item) return false;
  item.isDeleted = true;
  save(items,filePath);
  return true;
}
function updateById(id,itemData) {
  const items = loadData();
  const item = items.find((el) => el.id === id && !el.isDeleted);
  if(!item) return false;
  if(itemData.itemName) item.itemName = itemData.itemName;
  if(itemData.quantity) item.quantity = itemData.quantity;
  if(itemData.category) item.category = itemData.category;
  save(items,filePath);
  return true;
}
module.exports = { getAll, getItemById, createNewItem,deleteById,updateById };
