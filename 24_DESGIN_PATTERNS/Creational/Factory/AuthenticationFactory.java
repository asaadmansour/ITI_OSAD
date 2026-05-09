public class AuthenticationFactory {
    public Authenticator getAuthenticateMethod(AuthenticateMethod authenticateMethod) {
        if (authenticateMethod == AuthenticateMethod.USERNAMEPASSWORD) {
            return new UserNamePassword();
        }
        if (authenticateMethod == AuthenticateMethod.TWOWAYAUTH) {
            return new TwoWayAuth();
        }
        throw new IllegalArgumentException("Unsupported method");
    }
}
