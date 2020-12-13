package by.gsu.asoilab;

import by.gsu.asoilab.courses.Course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Progress {
    private Student student;
    private Course course;
    private int[] controlPoints;

    public static class Builder {
        Progress progress;

        public Builder() {
            progress = new Progress();
        }

        public Builder setStudent(Student student) {
            progress.student = student;
            return this;
        }

        public Builder setCourse(Course course) {
            progress.course = course;
            return this;
        }

        public Builder setControlPoints(int[] controlPoints) {
            progress.controlPoints = controlPoints;
            return this;
        }

        public Progress build() {
            return progress;
        }
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public int[] getControlPoints() {
        return controlPoints;
    }

    public int getAveragePoint() {
        double sumPoint = 0;
        for (int controlPoint : controlPoints) {
            sumPoint += controlPoint;
        }
        return (int)Math.round(sumPoint / controlPoints.length);
    }

    public int getMinPoint() {
        int minPoint = controlPoints[0];
        for (int controlPoint : controlPoints) {
            if (controlPoint < minPoint) {
                minPoint = controlPoint;
            }
        }
        return minPoint;
    }

    public int getMaxPoint() {
        int maxPoint = controlPoints[0];
        for (int controlPoint : controlPoints) {
            if (controlPoint > maxPoint) {
                maxPoint = controlPoint;
            }
        }
        return maxPoint;
    }

    private int getSummaryPoints() {
        int sumPoints = 0;
        for (int controlPoint : controlPoints) {
            sumPoints += controlPoint;
        }
        return sumPoints;
    }

    private int getAchievedPoints() {
        int sumPoints = 0;
        List<Achievement> achievements = course.getAchievements();
        for (Achievement achievement : achievements) {
            if (controlPoints[achievement.getTestNo() - 1] >= achievement.getRequiredPoints()) {
                sumPoints += achievement.getEarnedPoints();
            }
        }
        return sumPoints;
    }

    public void printEarnedAchievements() {
        List<String> earnedAchievements = new ArrayList<>();
        List<Achievement> achievements = course.getAchievements();
        for (Achievement achievement : achievements) {
            if (controlPoints[achievement.getTestNo() - 1] >= achievement.getRequiredPoints()) {
                earnedAchievements.add(String.format("Name: %s, earned points: %d",
                        achievement.getName(),
                        achievement.getEarnedPoints())
                );
            }
        }

        if (earnedAchievements.size() > 0) {
            for (String earnedAchievement : earnedAchievements) {
                System.out.println(earnedAchievement);
            }
        } else {
            System.out.println("You didn't earn any achievement");
        }
    }

    public int getTotalPoints() {
        return course.calculateTotalPoints(getSummaryPoints(), getAchievedPoints());
    }

    public boolean isPassed() {
        return getTotalPoints() >= course.getThresholdPoints();
    }

    public boolean isPassedWithHonors() {
        return getTotalPoints() >= course.getPointsToHonors();
    }

    @Override
    public String toString() {
        return String.format("%d;%d;%s", student.getId(), course.getId(), Arrays.toString(controlPoints));
    }
}
