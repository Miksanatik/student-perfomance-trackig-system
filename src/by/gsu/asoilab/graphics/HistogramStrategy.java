package by.gsu.asoilab.graphics;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class HistogramStrategy implements GraphicStrategy {
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
                g2.drawString("Max",X/3-30,Y-55);
                g2.drawString("Min",X/3,Y-55);
                g2.drawString("Avg",X/3+30,Y-55);
                g2.drawString("Max",X*2/3-30,Y-55);
                g2.drawString("Min",X*2/3,Y-55);
                g2.drawString("Avg",X*2/3+30,Y-55);

                g2.setColor(Color.PINK);
                g2.fillRect(X/3-30, (Y-75)-data[0]*(Y-100)/100,20,data[0]*(Y-100)/100 );
                g2.fillRect(X/3, (Y-75)-data[1]*(Y-75)/100,20,data[1]*(Y-75)/100 );
                g2.fillRect(X/3+30, (Y-75)-data[2]*(Y-75)/100,20,data[2]*(Y-75)/100 );
                g2.fillRect(X-75,(Y-50)/2,10,10);


                g2.setColor(Color.CYAN);
                g2.fillRect(X*2/3-30, (Y-75)-data[3]*(Y-100)/100,20,data[3]*(Y-100)/100 );
                g2.fillRect(X*2/3, (Y-75)-data[4]*(Y-100)/100,20,data[4]*(Y-100)/100 );
                g2.fillRect(X*2/3+30, (Y-75)-data[5]*(Y-100)/100,20,data[5]*(Y-100)/100 );
                g2.fillRect(X-75,(Y-50)/2+20,10,10);

                g2.setColor(Color.BLACK);
                g2.drawString("M", X-75+20,(Y-50)/2+10);
                g2.drawString("F", X-75+20,(Y-50)/2+30);


            }
        };
        frm.getContentPane().add(p);
        frm.setTitle(name);
    }
}
