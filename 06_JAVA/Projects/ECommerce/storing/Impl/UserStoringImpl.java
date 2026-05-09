package storing.Impl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import model.userModel.User;
import model.userModel.UserImp;
import storing.UserStoring;

public class UserStoringImpl implements UserStoring {
	private static final String USER_INFO_STORAGE = "users.csv";
	private static final String CURRENT_TASK_RESOURCE_FOLDER = "finaltask";
	private static final String RESOURCES_FOLDER = "resources";
	private static final int USER_EMAIL_INDEX = 4;
	private static final int USER_PASSWORD_INDEX = 3;
	private static final int USER_LASTNAME_INDEX = 2;
	private static final int USER_FIRSTNAME_INDEX = 1;
	private static final int USER_ID_INDEX = 0;
	
	private static UserStoringImpl instance;
	
	public static UserStoringImpl getInstance() {
		if (instance == null) {
			instance = new UserStoringImpl();
		}
		return instance;
	}

	@Override
	public void saveUser(User user) {
		try {
			// Append user to CSV file as a new line
			Files.writeString(
				Paths.get(RESOURCES_FOLDER, CURRENT_TASK_RESOURCE_FOLDER, USER_INFO_STORAGE),
				System.lineSeparator() + convertToStorableString(user), 
				StandardCharsets.UTF_8, 
				StandardOpenOption.CREATE,
				StandardOpenOption.APPEND
			);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Converts User object to CSV string format: "id,firstName,lastName,password,email"
	 */
	private String convertToStorableString(User user) {
		return user.getId() + "," + user.getFirstName() + "," + user.getLastName() + "," 
				+ user.getPassword() + "," + user.getEmail();
	}

	@Override
	public List<User> loadUsers() {
		try (var stream = Files
				.lines(Paths.get(RESOURCES_FOLDER, CURRENT_TASK_RESOURCE_FOLDER, USER_INFO_STORAGE))) {
			return stream
					.filter(Objects::nonNull)           // Remove null lines
					.filter(line -> !line.isEmpty())    // Remove empty lines
					.map(line -> {                      // Convert each line to User
						String[] userElements = line.split(",");
						return new UserImp(
								Integer.valueOf(userElements[USER_ID_INDEX]),
								userElements[USER_FIRSTNAME_INDEX],
								userElements[USER_LASTNAME_INDEX],
								userElements[USER_PASSWORD_INDEX],
								userElements[USER_EMAIL_INDEX]
						);
					})
					.collect(Collectors.toList());      // Collect into List
		} catch (IOException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
}
