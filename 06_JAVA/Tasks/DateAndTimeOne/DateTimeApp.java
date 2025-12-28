import java.util.Date;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class DateTimeApp extends JFrame implements Runnable {

    Thread th;

    public DateTimeApp() {
        setBounds(50, 50, 600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        th = new Thread(this);
        th.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DateTimeApp::new);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Date d = new Date();

                SwingUtilities.invokeLater(() ->
                    setTitle(d.toString())
                );

                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
