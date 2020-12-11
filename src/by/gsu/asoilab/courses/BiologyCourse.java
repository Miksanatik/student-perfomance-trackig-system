package by.gsu.asoilab.courses;

import by.gsu.asoilab.Achievement;

import java.util.List;

public class BiologyCourse extends Course {
    public BiologyCourse(int id, String name, int thresholdPoints, int pointsToHonors, List<Achievement> achievements) {
        super(id, name, thresholdPoints, pointsToHonors, achievements);
    }

    public int getTotalPointsFormula(int summaryPoints, int achievedPoints) {
        double result = summaryPoints + 0.75 * achievedPoints;
        return (int)Math.round(result);
    }
}
