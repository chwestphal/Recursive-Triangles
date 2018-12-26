import java.awt.Color;
import javax.swing.JFrame;

public class Frame {
    JFrame frame;

        public Frame() {
            frame = new JFrame();
            frame.add(new Draw(1440,900));
            frame.pack();
            frame.setSize(1440,900);
            frame.setVisible(true);
            frame.setBackground(Color.WHITE);
        }

        public static void main (String args[]) {
                Frame frame = new Frame();
        }
    }

