package by.gsu.asoilab.graphics;


public class Graphic {
    protected GraphicStrategy graphicStrategy;

    public void create(int[] data) {
        graphicStrategy.create(data);
    }
}
