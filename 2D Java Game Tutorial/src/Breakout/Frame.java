package Breakout;

import javax.swing.JFrame;

public class Frame extends JFrame {

    public Frame()
    {
        add(new Board());
        setTitle("Breakout");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Commons.Width, Commons.Height);
        setLocationRelativeTo(null);
        setIgnoreRepaint(true);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Frame();
    }
}
