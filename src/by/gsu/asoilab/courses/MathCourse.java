package by.gsu.asoilab.courses;

import by.gsu.asoilab.Achievement;

import java.util.List;

public class MathCourse  extends Course {
    public MathCourse(int id, String name, int thresholdPoints, int pointsToHonors, List<Achievement> achievements) {
        super(id, name, thresholdPoints, pointsToHonors, achievements);
    }

    public int getTotalPointsFormula(int summaryPoints, int achievedPoints) {
        double result = 0.9 * summaryPoints + 0.8 * achievedPoints;
        return (int)Math.round(result);
    }
}
