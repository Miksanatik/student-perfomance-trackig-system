package by.gsu.asoilab.graphics;

public class DotPlot extends Graphic {
    public DotPlot() {
        this.graphicStrategy = new DotPlotStrategy();
    }
}
