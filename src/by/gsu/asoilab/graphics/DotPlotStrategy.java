package by.gsu.asoilab.graphics;


import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class DotPlotStrategy implements GraphicStrategy {
    private final int X = 500;
    private final int Y = 300;
    @Override
    public void create(int[] data, String name) {
        JFrame frm = new JFrame();
        frm.setSize(new Dimension(X, Y));
        //frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);

        JPanel p = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.drawLine(25, 25, 25, Y-75);
                g2.drawLine(25, Y-75, X-45, Y-75);
                g2.drawString("100", 5, 25);
                g2.drawString("50", 5, (Y-50)/2);
                g2.drawString("0", 5, Y-75);
                for (int i = 0; i < 5; i++) {
                    g2.drawString("test " + (i + 1), 15 + i * (X-70)/4, Y-50);
                }
                g2.setColor(Color.PINK);
                g2.setStroke(new BasicStroke(3.0f));
                int x1 = 25;
                int y1 = Y-50 - (data[0] * (Y-75)/100);
                for (int i = 0; i < data.length - 1; i++) {
                    int x2 = 25 + (i + 1) * (X-70)/4;
                    int y2 = Y-50 - (data[i] * (Y-75)/100);
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
