public class Main2 {
    public static void main(String[] args) {
        SessionManager sessionManager = SessionManager.getInstance();
        SessionManager sessionManager1 = SessionManager.getInstance();
        System.out.println(sessionManager == sessionManager1);
        sessionManager.createSession(1);
        sessionManager.createSession(2);
        sessionManager.createSession(3);
        sessionManager.createSession(4);
        sessionManager1.getSession(3);
        sessionManager1.removeSession(3);
    }
}
