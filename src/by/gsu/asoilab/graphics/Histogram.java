package by.gsu.asoilab.graphics;

public class Histogram extends Graphic {
    public Histogram() {
        this.graphicStrategy = new HistogramStrategy();
    }
}
