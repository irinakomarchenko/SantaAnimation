package hexlet.code;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;

public class SantaAnimation {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SantaFrame();
            }
        });
    }

    static class SantaFrame extends JFrame {
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
}
