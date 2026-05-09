package storing;

import java.util.List;

import model.userModel.User;

public interface UserStoring {
    void saveUser(User user);
	List<User> loadUsers();   
}
