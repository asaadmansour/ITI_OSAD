public class DaemonDemo2 {
    public static void main(String[] args) throws InterruptedException {
        Thread helper = new Thread(() -> {
            try {
                for (int i = 1; i <= 100; i++) {
                    Thread.sleep(100); // Helper waits 0.1 seconds
                    System.out.println("Helper counting: " + i);
                }
            } catch (InterruptedException e) {
                // Daemon threads are killed so abruptly they often don't even get to catch this
                System.out.println("Helper was interrupted!");
            }
        });

        helper.setDaemon(true);
        helper.start();

        // Make the Main thread sleep for 500ms (0.5 seconds)
        // This gives the helper enough time to print about 4 or 5 times
        Thread.sleep(500);

        System.out.println("Main thread (The Boss) is finishing now...");
        // At this point, JVM sees no more USER threads and kills the Daemon
    }
}