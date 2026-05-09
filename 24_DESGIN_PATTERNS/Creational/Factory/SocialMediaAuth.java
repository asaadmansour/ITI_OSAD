public class SocialMediaAuth implements Authenticator{
    @Override
    public String Authenticate(String info) {
        if (info.isEmpty())
            return "non";
        return "Authenticated Using Social Media";
    }
}
