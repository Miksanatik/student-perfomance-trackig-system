package by.gsu.asoilab.courses;

import by.gsu.asoilab.Achievement;

import java.util.List;
import java.util.Objects;

public abstract class Course {
    private final int id;
    private final String name;
    private final int thresholdPoints;
    private final int pointsToHonors;
    private final List<Achievement> achievements;

    public Course(int id, String name, int thresholdPoints, int pointsToHonors, List<Achievement> achievements) {
        this.id = id;
        this.name = name;
        this.thresholdPoints = thresholdPoints;
        this.pointsToHonors = pointsToHonors;
        this.achievements = achievements;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getThresholdPoints() {
        return thresholdPoints;
    }

    public int getPointsToHonors() {
        return pointsToHonors;
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }

    public abstract int getTotalPointsFormula(int summaryPoints, int achievedPoints);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id &&
                thresholdPoints == course.thresholdPoints &&
                pointsToHonors == course.pointsToHonors &&
                Objects.equals(name, course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, thresholdPoints, pointsToHonors);
    }

    @Override
    public String toString() {
        return String.format("%d;%s;%d;%d", id, name, thresholdPoints, pointsToHonors);
    }
}
