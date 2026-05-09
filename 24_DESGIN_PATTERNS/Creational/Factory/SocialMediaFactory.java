public class SocialMediaFactory {
    public Authenticator getAuthenticationMethod(String authenticateMethod) {
        if (authenticateMethod.equals("Facebook"))
            return new FaceBook();
        if (authenticateMethod.equals("Instagram"))
            return new Instagram();
        throw new IllegalArgumentException("Unsupported social media");
    }

}
