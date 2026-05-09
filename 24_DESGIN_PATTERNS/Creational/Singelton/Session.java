public class Session {
    private final Integer userId;
    private final boolean isActive;
    private final long createdAt;

    public Session(Integer userId, boolean isActive) {
        this.userId = userId;
        this.isActive = isActive;
        this.createdAt = System.currentTimeMillis();
    }

    public Integer getUserId() {
        return userId;
    }

    public boolean isActive() {
        return isActive;
    }

    public long getCreatedAt() {
        return createdAt;
    }
}
