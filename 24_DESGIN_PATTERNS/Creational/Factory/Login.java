public class Login {
    private final AuthenticationFactory authenticationFactory;
    private final SocialMediaFactory socialMediaFactory;

    public Login(AuthenticationFactory authenticationFactory, SocialMediaFactory socialMediaFactory) {
        this.authenticationFactory = authenticationFactory;
        this.socialMediaFactory = socialMediaFactory;
    }

    public void Authenticate(AuthenticateMethod method, String info) {
        Authenticator authenticator = authenticationFactory.getAuthenticateMethod(method);
        System.out.println(authenticator.Authenticate(info));
    }

    public void AuthenticateSocial(String platform, String info) {
        Authenticator authenticator = socialMediaFactory.getAuthenticationMethod(platform);
        System.out.println(authenticator.Authenticate(info));
    }
}
