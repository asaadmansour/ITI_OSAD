const mongoose = require('mongoose');

const productsSchema = new mongoose.Schema({
  owner: {
    type: mongoose.Types.ObjectId,
    ref: 'Users'
  },
  name: {
    type: String,
    minLength: 5,
    maxLength: 20,
    required: true,
    unique: true
  },
  category: {
    type: String,
    default: 'general'
  },
  quantity: {
    type: Number,
    required: true
  },
  createdAt: {
    type: Date,
    default: Date.now
  },
  updatedAt: {
    type: Date,
    default: Date.now
  }
});

productsSchema.virtual('status').get(function () {
  if (this.quantity === 0) return 'Out of Stock';
  if (this.quantity <= 2) return 'Low Stock';
  return 'Available';
});
productsSchema.set('toJSON', {virtuals: true});
productsSchema.set('toObject', {virtuals: true});
const Proudcts = mongoose.model('products', productsSchema);

module.exports = Proudcts;
