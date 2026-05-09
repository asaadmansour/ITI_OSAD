public class Main {
    public static void main(String[] args) {
        String user = "admin";
        Streaming permissionProxyStreamingService = new PermissionProxyStreamingService(user);
        permissionProxyStreamingService.stream();
    }
}
