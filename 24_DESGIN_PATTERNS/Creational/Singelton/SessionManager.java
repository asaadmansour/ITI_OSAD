import java.util.HashMap;
import java.util.Map;

public class SessionManager {
    private static volatile SessionManager instance;
    private final Map<Integer,Session> userSessions = new HashMap<>();
    private SessionManager() {};
    public static SessionManager getInstance() {
        if (instance == null) {
            synchronized (SessionManager.class) {
                if (instance == null)  {
                    instance = new SessionManager();
                }
            }
        }
        return instance;
    }
    public boolean createSession(Integer userId) {
        Session session = new Session(userId,true);
        userSessions.put(userId,session);
        return true;
    }

    public Session getSession(Integer userId) {
        return userSessions.get(userId);
    }
    public Session removeSession(Integer userId) {
        return userSessions.remove(userId);
    }
}
