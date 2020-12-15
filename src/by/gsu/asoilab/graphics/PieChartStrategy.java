package by.gsu.asoilab.graphics;

import javax.swing.*;
import java.awt.*;

public class PieChartStrategy implements GraphicStrategy {
    private final int X = 500;
    private final int Y = 300;
    private int sum;

    @Override
    public void create(int[] data, String name) {

        for(int i = 0; i<data.length; i++) {
            sum+= data[i];
        }
        System.out.println(sum);
        JFrame frm = new JFrame();
        frm.setSize(new Dimension(X, Y));
        //frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);

        JPanel p = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                int startAngle = 0;
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.GREEN);
                g2.fillArc(20,20,Y-80,Y-80, startAngle,(int)(1.0*data[0]/sum*360));
                startAngle += (int)(1.0*data[0]/sum*360);
                g2.setColor(Color.ORANGE);
                g2.fillArc(20,20,Y-80,Y-80, startAngle,(int)(1.0*data[1]/sum*360));
                startAngle += (int)(1.0*data[1]/sum*360);
                g2.setColor(Color.BLUE);
                g2.fillArc(20,20,Y-80,Y-80, startAngle,360-startAngle);


                g2.setColor(Color.GREEN);
                g2.fillRect(X-150,(Y-50)/2-20,10,10);
                g2.setColor(Color.ORANGE);
                g2.fillRect(X-150,(Y-50)/2,10,10);
                g2.setColor(Color.BLUE);
                g2.fillRect(X-150,(Y-50)/2+20,10,10);

                g2.setColor(Color.BLACK);
                g2.drawString("Passed with honors", X-150+20,(Y-50)/2-10);
                g2.drawString("Passed", X-150+20,(Y-50)/2+10);
                g2.drawString("Not passed", X-150+20,(Y-50)/2+30);
            }
        };
        frm.getContentPane().add(p);
        frm.setTitle(name);
    }
}
