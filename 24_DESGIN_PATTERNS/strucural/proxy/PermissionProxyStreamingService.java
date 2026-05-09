public class PermissionProxyStreamingService implements Streaming {
    private  StreamingService streamingService;
    private final String user;
    public PermissionProxyStreamingService(String user) {
        this.user = user;
    }

    @Override
    public void stream() {
        if (!user.equals("admin")) {
            System.out.println("not authorized");
            return;
        }
        if (streamingService == null) {
            System.out.println("Initializing streaming service...");
            streamingService = new StreamingService();
        }

        streamingService.stream();
    }
}
