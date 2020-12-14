package by.gsu.asoilab.graphics;


import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class DotPlotStrategy implements GraphicStrategy {
    @Override
    public void create(int[] data, String name) {
        JFrame frm = new JFrame();
        frm.setSize(new Dimension(500, 300));
        //frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);

        JPanel p = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.drawLine(25, 25, 25, 225);
                g2.drawLine(25, 225, 455, 225);
                g2.drawString("100", 5, 25);
                g2.drawString("50", 5, 125);
                g2.drawString("0", 5, 225);
                for (int i = 0; i < 5; i++) {
                    g2.drawString("test " + (i + 1), 15 + i * 108, 250);
                }
                g2.setColor(Color.PINK);
                g2.setStroke(new BasicStroke(3.0f));
                int x1 = 25;
                int y1 = 250 - (int) (data[0] * 2.25);
                for (int i = 0; i < data.length - 1; i++) {
                    int x2 = 25 + (i + 1) * 108;
                    int y2 = 250 - (int) (data[i + 1] * 2.25);
                    g2.drawLine(x1, y1, x2, y2);
                    x1 = x2;
                    y1 = y2;
                }
            }
        };
        frm.setTitle(name);
        frm.getContentPane().add(p);
    }
}
