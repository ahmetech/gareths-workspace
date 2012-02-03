package movingspritesshootingmissles;

import javax.swing.JFrame;

public class Frame extends JFrame {

    public Frame() {
        add(new Board());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 900);
        setLocationRelativeTo(null);
        setTitle("Collision");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Frame();
    }
}
