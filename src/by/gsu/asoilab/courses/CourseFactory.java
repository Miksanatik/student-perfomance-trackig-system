package by.gsu.asoilab.courses;

import by.gsu.asoilab.courses.*;

public class CourseFactory {
    public static class Builder {
        private int id;
        private String name;
        private int thresholdPoints;
        private int pointsToHonors;
        private CourseCategories category;

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

        public Builder setCategory(CourseCategories category) {
            this.category = category;
            return this;
        }

        public Course build() {
            Course course;
            switch (category) {
                case PROGRAMMING: {
                    course = new ProgrammingCourse(id, name, thresholdPoints, pointsToHonors);
                    break;
                }
                case MATH: {
                    course = new MathCourse(id, name, thresholdPoints, pointsToHonors);
                    break;
                }
                case BIOLOGY: {
                    course = new BiologyCourse(id, name, thresholdPoints, pointsToHonors);
                    break;
                }
                case PHYSICS: {
                    course = new PhysicsCourse(id, name, thresholdPoints, pointsToHonors);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Wrong course category: " + category);
                }
            }

            return course;
        }

    }

}
