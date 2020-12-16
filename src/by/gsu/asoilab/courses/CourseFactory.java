package by.gsu.asoilab.courses;

import by.gsu.asoilab.Achievement;

import java.util.List;

public class CourseFactory {
    public static class Builder {
        private int id;
        private String name;
        private int thresholdPoints;
        private int pointsToHonors;
        private CourseCategories category;
        private List<Achievement> achievements;

        public Builder(CourseCategories category) {
            this.category = category;
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setThresholdPoints(int thresholdPoints) {
            this.thresholdPoints = thresholdPoints;
            return this;
        }

        public Builder setPointsToHonors(int pointsToHonors) {
            this.pointsToHonors = pointsToHonors;
            return this;
        }

        public Builder setAchievements(List<Achievement> achievements) {
            this.achievements = achievements;
            return this;
        }

        public Course build() {
            return category.createCourse(id, name, thresholdPoints, pointsToHonors, achievements);
        }

    }

}