const express = require('express');
const mongoose = require('mongoose');

mongoose.connect('mongodb://127.0.0.1:27017/inventory');
const app = express();
app.use(express.json());
const process = require('node:process');
const CustomError = require('./helpers/CustomError');

app.use('/', require('./routes'));

app.use((error, req, res, next) => {
  if (error instanceof CustomError) {
    return res.status(error.statusCode).json({code: error.code, message: error.message});
  }
  console.error(error);
  res.status(500).json({error: error.message});
});
const PORT = process.env.PORT || 3000;
app.listen(PORT, (error) => {
  if (error) {
    return console.log(error);
  }
  console.log(`Up and running: http://127.0.0.1:${PORT}`);
});
