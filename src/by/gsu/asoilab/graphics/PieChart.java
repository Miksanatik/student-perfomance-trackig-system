package by.gsu.asoilab.graphics;

public class PieChart extends Graphic {
    public PieChart() {
        this.graphicStrategy = new PieChartStrategy();
    }
}
