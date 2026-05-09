const express = require('express');
const {usersController} = require('../controllers');
const {authMiddleWare} = require('../middleware/auth');
const canEdit = require('../middleware/roleAuthorization');
// const userVerification = require('../middleware/userVerification');

const router = express.Router();

router.get('/', async (req, res) => {
  const allUsers = await usersController.get();
  res.status(200).json(allUsers);
});
router.get('/:id', async (req, res) => {
  const {id} = req.params;
  const user = await usersController.getById(id);
  res.json(user);
});
router.post('/signup', async (req, res) => {
  const {body} = req;
  const user = await usersController.create(body);
  // call controller function to create user
  res.json(user);
});
router.post('/login', async (req, res) => {
  const {body} = req;
  const jwt = await usersController.validate(body);
  res.json(jwt);
  console.log('done');
});
router.patch('/:id', authMiddleWare, canEdit, async (req, res) => {
  try {
    const {id} = req.params;
    const updatedUser = await usersController.update(id, req.body);
    res.json({message: 'user was edited successfully', user: updatedUser});
    console.log('Done');
  } catch (err) {
    console.log(err);
  }
});
router.delete('/:id', authMiddleWare, canEdit, async (req, res) => {
  const {id} = req.params;
  const deletedUser = await usersController.deleteUser(id);
  res.json(deletedUser);
  console.log('done');
});
module.exports = router;
