package service;

import model.userModel.User;

public interface UserManagementService {
    String registerUser(User user);
	User[] getUsers();
	User getUserByEmail(String userEmail);
	void clearServiceState();
}
