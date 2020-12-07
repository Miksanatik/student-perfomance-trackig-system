package by.gsu.asoilab.courses;

public abstract class Course {
    private final int id;
    private final String name;
    private final int thresholdPoints;
    private final int pointsToHonors;

    public Course(int id, String name, int thresholdPoints, int pointsToHonors) {
        this.id = id;
        this.name = name;
        this.thresholdPoints = thresholdPoints;
        this.pointsToHonors = pointsToHonors;
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

    public int getPointsToPassWithHonors() {
        return pointsToHonors - thresholdPoints;
    }

    @Override
    public String toString() {
        return String.format("%d;%s;%d;%d", id, name, thresholdPoints, pointsToHonors);
    }
}
