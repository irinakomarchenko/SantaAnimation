package hexlet.code;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class SantaPanel extends JPanel {
    private int santaX = -200;
    private final int santaSpeed = 2;
    private String fullText = "Happy New Year 2025, Hexlet!";
    private String displayedText = "";
    private boolean cursorVisible = true;

    public void startAnimation() {
        Timer santaTimer = new Timer(20, e -> {
            santaX += santaSpeed;
            if (santaX > getWidth()) {
                santaX = -200;
            }
            repaint();
        });
        santaTimer.start();

        Timer typingTimer = new Timer(200, e -> {
            if (displayedText.length() < fullText.length()) {
                displayedText += fullText.charAt(displayedText.length());
            } else {
                cursorVisible = !cursorVisible;
            }
            repaint();
        });
        typingTimer.start();

        AudioPlayer.playMusic();
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

        drawSanta(g);
        drawText(g);
    }

    private void drawSanta(Graphics g) {
        int x = santaX;
        int y = 150;

        g.setColor(Color.RED);
        g.fillOval(x, y, 100, 100);

        g.setColor(Color.PINK);
        g.fillOval(x + 25, y - 50, 50, 50);

        g.setColor(Color.MAGENTA);
        g.fillOval(x + 40, y - 35, 10, 10);
        g.fillOval(x + 60, y - 35, 10, 10);

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
    }

    private void drawText(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(50, getHeight() - 100, getWidth() - 100, 80);
        g.setColor(Color.GREEN);
        g.setFont(new Font("Monospaced", Font.PLAIN, 16));

        g.drawString(displayedText, 60, getHeight() - 60);
        if (cursorVisible) {
            int cursorX = 60 + g.getFontMetrics().stringWidth(displayedText);
            g.drawLine(cursorX, getHeight() - 75, cursorX, getHeight() - 55);
        }
    }
}
