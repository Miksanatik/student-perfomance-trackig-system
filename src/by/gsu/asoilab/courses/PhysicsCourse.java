package by.gsu.asoilab.courses;

import by.gsu.asoilab.Achievement;

import java.util.List;

public class PhysicsCourse extends Course {
    public PhysicsCourse(int id, String name, int thresholdPoints, int pointsToHonors, List<Achievement> achievements) {
        super(id, name, thresholdPoints, pointsToHonors, achievements);
    }

    public int calculateTotalPoints(int summaryPoints, int achievedPoints) {
        double result = 0.85 * summaryPoints + achievedPoints;
        return (int)Math.round(result);
    }
}