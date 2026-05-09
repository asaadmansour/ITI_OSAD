const fs = require("fs").promises;
const path = require("path");
const filePath = path.join(__dirname, "inventory.json");
let data = [];

async function loadData() {
  try {
    const fileContent = await fs.readFile(filePath, "utf8");
    return JSON.parse(fileContent);
  } catch (err) {
    if (err.code === "ENOENT") {
      return [];
    }
    throw err;
  }
}
function returnQuantityStatus(item) {
  if (item.quantity > 2) return "available";
  if (item.quantity <= 2 && item.quantity > 0) return "Low Stock";
  if (item.quantity === 0) return "Out of stock";
}
function generateId(data) {
  if (data.length === 0) return 1;
  const lastId = parseInt(data[data.length - 1].id);
  return lastId + 1;
}
function getElementWithId(arr, id) {
  return arr.find((item) => item.id == id) || null;
}
async function add(itemName) {
  data = await loadData();
  let itemObj = {
    id: generateId(data),
    itemName: itemName,
    quantity: 1,
    category: "general",
    isDeleted: false,
  };
  data.push(itemObj);
  await fs.writeFile(filePath, JSON.stringify(data, null, 2), "utf8");
}
async function destock(id, quantity) {
  data = await loadData();
  const item = getElementWithId(data, id);
  if (!item) {
    console.log("Item not found");
    return;
  }
  if (quantity >= item.quantity) {
    console.log("Cannot destock: not enough quantity");
    return;
  }
  item.quantity = item.quantity - quantity;
  await fs.writeFile(filePath, JSON.stringify(data, null, 2), "utf8");
}
async function restock(id, quantity) {
  data = await loadData();
  const item = getElementWithId(data, id);
  if (!item) {
    console.log("Item not found");
    return;
  }
  item.quantity += quantity;
  await fs.writeFile(filePath, JSON.stringify(data, null, 2), "utf8");
}
async function editName(id, name) {
  data = await loadData();
  const item = getElementWithId(data, id);
  if (!item) {
    console.log("Item not found");
    return;
  }
  item.itemName = name;
  await fs.writeFile(filePath, JSON.stringify(data, null, 2));
}
async function deleteItem(id) {
  data = await loadData();
  const item = getElementWithId(data, id);
  if (!item) {
    console.log("Item not found");
    return;
  }
  item.isDeleted = true;
  await fs.writeFile(filePath, JSON.stringify(data, null, 2));
}
async function listItems() {
  const data = await loadData();
  const formatted = data
    .filter((item) => !item.isDeleted)
    .map((item) => ({
      ID: item.id,
      Name: item.itemName,
      Category: item.category,
      Quantity: item.quantity,
      Status: returnQuantityStatus(item),
    }));

  console.table(formatted);
}
async function viewSummary() {
  const data = await loadData();
  const activeItems = data.filter((item) => !item.isDeleted);
  const totalItems = activeItems.length;
  const totalQuantity = activeItems.reduce(
    (sum, item) => sum + item.quantity,
    0,
  );
  const available = activeItems.filter((item) => item.quantity > 2).length;
  const lowStock = activeItems.filter(
    (item) => item.quantity <= 2 && item.quantity > 0,
  ).length;
  const outOfStock = activeItems.filter((item) => item.quantity === 0).length;
  console.log("=== Inventory Summary ===");
  console.log(`Total number of items: ${totalItems}`);
  console.log(`Total quantity: ${totalQuantity}`);
  console.log(`Available: ${available}`);
  console.log(`Low Stock: ${lowStock}`);
  console.log(`Out of Stock: ${outOfStock}`);
}
const [, , command, value] = process.argv;
let values = value ? value.split(" ") : [];
console.log(command, values);
if (command === "add") {
  add(values[0]).then(() => console.log(data));
}
if (command === "destock") {
  destock(Number(values[0]), Number(values[1]));
}
if (command === "restock") {
  restock(Number(values[0]), Number(values[1]));
}
if (command === "edit") {
  editName(Number(values[0]), values[1]);
}
if (command === "delete") {
  deleteItem(Number(values[0]));
}
if (command === "list") {
  listItems();
}
if (command === "summary") {
  viewSummary();
}
