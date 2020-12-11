package by.gsu.asoilab.courses;

import by.gsu.asoilab.Achievement;

import java.util.List;

public enum CourseCategories {
    PROGRAMMING("Programming") {
        public Course createCourse(int id, String name, int thresholdPoints, int pointsToHonors, List<Achievement> achievements) {
            return new ProgrammingCourse(id, name, thresholdPoints, pointsToHonors, achievements);
        }
    },
    MATH("Math") {
        public Course createCourse(int id, String name, int thresholdPoints, int pointsToHonors, List<Achievement> achievements) {
            return new MathCourse(id, name, thresholdPoints, pointsToHonors, achievements);
        }
    },
    BIOLOGY("Biology") {
        public Course createCourse(int id, String name, int thresholdPoints, int pointsToHonors, List<Achievement> achievements) {
            return new BiologyCourse(id, name, thresholdPoints, pointsToHonors, achievements);
        }
    },
    PHYSICS("Physics") {
        public Course createCourse(int id, String name, int thresholdPoints, int pointsToHonors, List<Achievement> achievements) {
            return new PhysicsCourse(id, name, thresholdPoints, pointsToHonors, achievements);
        }
    };

    private String course;

    CourseCategories(String course) {
        this.course = course;
    }

    public abstract Course createCourse(int id, String name, int thresholdPoints, int pointsToHonors, List<Achievement> achievements);

    @Override
    public String toString() {
        return course;
    }
}
