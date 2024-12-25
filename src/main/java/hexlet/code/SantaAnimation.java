package hexlet.code;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class SantaAnimation {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(SantaFrame::new);
    }
}

class SantaFrame extends JFrame {
    public SantaFrame() {
        setTitle("Santa Animation");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        SantaPanel panel = new SantaPanel();
        add(panel);

        setVisible(true);
        panel.startAnimation();
    }
}

class SantaPanel extends JPanel {
    private int santaX = -200;
    private final int santaSpeed = 2;

    public void startAnimation() {
        Timer timer = new Timer(20, e -> {
            santaX += santaSpeed;
            if (santaX > getWidth()) {
                santaX = -200;
            }
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.CYAN);
        g.fillRect(0, 0, getWidth(), getHeight());


        g.setColor(Color.WHITE);
        for (int i = 0; i < 100; i++) {
            int x = (int) (Math.random() * getWidth());
            int y = (int) (Math.random() * getHeight());
            g.fillOval(x, y, 5, 5);
        }

        int x = santaX;
        int y = 150;

        g.setColor(Color.RED);
        g.fillOval(x, y, 100, 100);

        g.setColor(Color.PINK);
        g.fillOval(x + 25, y - 50, 50, 50);

        g.setColor(Color.MAGENTA);
        g.fillOval(x + 40, y - 35, 10, 10); // Левый глаз
        g.fillOval(x + 60, y - 35, 10, 10); // Правый глаз

        g.setColor(Color.RED);
        g.drawArc(x + 40, y - 25, 30, 15, 0, -180);

        g.setColor(Color.RED);
        g.fillArc(x + 20, y - 60, 60, 30, 0, 180);
        g.setColor(Color.WHITE);
        g.fillOval(x + 45, y - 70, 10, 10);

        g.setColor(Color.RED);
        g.fillRect(x - 20, y + 30, 40, 10);
        g.fillRect(x + 80, y + 30, 40, 10);

        g.setColor(Color.WHITE);
        g.fillRect(x + 20, y + 90, 60, 10);
        g.setColor(Color.BLACK);
        g.fillRect(x + 40, y + 90, 20, 10);

        g.setColor(Color.WHITE);
        g.fillOval(x + 30, y - 10, 40, 30);
        g.fillOval(x + 20, y + 10, 60, 40);

        g.setColor(Color.blue);
        g.fillRect(santaX + 70, getHeight() / 2 - 140, 250, 60);
        g.setColor(Color.WHITE);
        g.drawRect(santaX + 70, getHeight() / 2 - 140, 250, 60);
        g.setFont(new Font("Serif", Font.BOLD, 18));
        g.drawString("Happy New Year 2025, Hexlet!", santaX + 80, getHeight() / 2 - 110);
    }
}
