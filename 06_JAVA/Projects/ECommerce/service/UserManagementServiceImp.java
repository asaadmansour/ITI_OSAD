package service;

import model.userModel.User;

public class UserManagementServiceImp implements UserManagementService {
    private static UserManagementService instance; //singelton only one instance exists
    private User[] users = new User[0]; // initializing new array with 0 users;
    private UserManagementServiceImp(){} // private constructor  
    public static UserManagementService getInstance() {
        if(instance == null)
            instance = new UserManagementServiceImp();
        return instance;
    }
    public String registerUser(User user){
        if(getUserByEmail(user.getEmail()) != null)
            return "User already exists";
        User[] newUsers = new User[users.length + 1];
        for(int i = 0; i < users.length; i++) {
            newUsers[i] = users[i];
        }
        newUsers[users.length] = user;
        users = newUsers;
        return null;
    }
	public User[] getUsers(){
        return users;
    }
	public User getUserByEmail(String userEmail){
        for (User user : users) {
            if(user.getEmail().equals(userEmail))
                return user;
        }
        return null;
    }
    public void clearServiceState() {
        instance = null;
        users = new User[0];
    }
}
