public class Main4 {
    public static void main(String[] args) {
        AuthenticationFactory authenticationFactory = new AuthenticationFactory();
        SocialMediaFactory socialMediaFactory = new SocialMediaFactory();
        Login login = new Login(authenticationFactory, socialMediaFactory);

        login.Authenticate(AuthenticateMethod.TWOWAYAUTH, "my_token");
        login.Authenticate(AuthenticateMethod.USERNAMEPASSWORD, "user:pass");
        login.AuthenticateSocial("Facebook", "fb_token");
        login.AuthenticateSocial("Instagram", "ig_token");
    }
}
