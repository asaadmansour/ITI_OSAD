public class StreamingService implements Streaming {
    public void stream() {
        for (int i = 0; i < 1000000000; i++) {
            System.out.println("streaming..");
        }
    }
}
