import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Lines extends JPanel {

    int coords[][];
    int count;

    public Lines() {

        coords = new int [100][2];
        count = 0;

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent event) {
                if (event.getButton() == event.BUTTON1) {

                    int x = event.getX();
                    int y = event.getY();

                    coords[count][0] = x;
                    coords[count][1] = y;
                    count++;
                }

                if (event.getButton() == event.BUTTON3) {
                    drawLines();
                    count = 0;
                }
            }
        });
    }

    public void drawLines() {

        Graphics g = this.getGraphics();

        Graphics2D g2d = (Graphics2D) g;

        int w = getWidth();
        int h = getHeight();

        RenderingHints rh =
            new RenderingHints(RenderingHints.KEY_ANTIALIASING, 
            RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
               RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        g2d.clearRect(0, 0, w, h);


        for ( int i = 0; i < count-1; i++ ) {
            for (int j = 0; j < count-1; j++)
                g2d.drawLine(coords[i][0], coords[i][1],
                    coords[j][0], coords[j][1]);
        }
    }

    public static void main(String[] args) {

        Lines lines = new Lines();
        JFrame frame = new JFrame("Lines");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(lines);
        frame.setSize(1920, 1080);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}