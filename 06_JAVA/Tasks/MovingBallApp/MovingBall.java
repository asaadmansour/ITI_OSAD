import javax.swing.*;
import java.awt.*;

public class MovingBall extends JFrame {

    JLabel ball = new JLabel();
    int x = 50, y = 50;
    int dx = 3, dy = 3;

    public MovingBall() {
        setTitle("Moving Ball App");
        setSize(600, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ball.setOpaque(true);
        ball.setBackground(Color.RED);
        ball.setBounds(x, y, 30, 30);
        add(ball);

        Timer timer = new Timer(12, e -> update());
        timer.start();

        setVisible(true);
    }

    private void update() {
        x += dx;
        y += dy;

        if (x <= 0 || x >= getWidth() - 30) dx = -dx;
        if (y <= 0 || y >= getHeight() - 30) dy = -dy;

        ball.setLocation(x, y);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MovingBall::new);
    }
}
