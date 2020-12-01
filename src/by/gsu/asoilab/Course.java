package by.gsu.asoilab;

public abstract class Course {
    private final int id;
    private final String name;
    private final int maxPoints;
    private final int threshold;
    private final int pointsToHonors;


    public Course(int id, String name, int maxPoints, int threshold, int pointsToHonors) {
        this.id = id;
        this.name = name;
        this.maxPoints = maxPoints;
        this.threshold = threshold;
        this.pointsToHonors = pointsToHonors;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public int getThreshold() {
        return threshold;
    }

    public int getPointsToHonors() {
        return pointsToHonors;
    }

    public int getPointsToPassWithHonors() {
        return pointsToHonors - threshold;
    }

    @Override
    public String toString() {
        return String.format("%d;%s;%d;%d;%d", id, name, maxPoints, threshold, pointsToHonors);
    }
}
