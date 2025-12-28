class Main {
    public static void main(String[] args) {
        UserRegistration r1 = new UserRegistration();
        try {
            r1.registerUser("asaad", "Password123");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        UserLogin l1 = new UserLogin();
        try {
            l1.loginUser("asaad", "Password123");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

class UserLogin {
    public void loginUser(String username, String password) {
        UserName validUsername = new UserName(username);
        Password validPassword = new Password(password);
        
        // If we get here, validation passed
        System.out.println("User logged in successfully!");
    }
}

class UserRegistration {
    public void registerUser(String username, String password) {
        UserName validUsername = new UserName(username);
        Password validPassword = new Password(password);
        System.out.println("User registered successfully.");
    }
}

class UserName {
    private final String username;
    
    public UserName(String username) {
        if (!validateUsername(username)) {
            throw new IllegalArgumentException("Invalid username: must be at least 5 characters and contain only letters, numbers, or underscores");
        }
        this.username = username;
    }
    
    public String getUsername() {
        return username;
    }
    
    private boolean validateUsername(String username) {
        return username != null && 
               username.length() >= 5 && 
               username.matches("[a-zA-Z_0-9]+");
    }
}

class Password {
    private final String password;
    
    public Password(String password) {
        if (!validatePassword(password)) {  // FIXED: was missing !
            throw new IllegalArgumentException("Invalid password: must be at least 8 characters and contain at least one uppercase letter, one lowercase letter, and one digit");    
        }
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }
    
    private boolean validatePassword(String password) {
        return password != null && 
               password.length() >= 8 && 
               password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");
    }
}