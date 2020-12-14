package by.gsu.asoilab.graphics;


public class Graphic {
    protected GraphicStrategy graphicStrategy;

    public void create(int[] data, String str) {
        graphicStrategy.create(data, str);
    }
}
