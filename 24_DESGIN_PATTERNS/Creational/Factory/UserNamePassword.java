public class UserNamePassword implements Authenticator{
    @Override
    public String Authenticate(String info) {
        if (info.isEmpty())
            return "non";
        return "Authenticated Using Username And Password";
    }
}
