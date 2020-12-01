package by.gsu.asoilab;

public class CourseFactory {
    public Course createCourse(CourseCategories category, int id, String name, int maxPoints, int threshold, int pointsToHonors) {
        Course course = null;
        switch(category) {
            case PROGRAMMING:
                course = new ProgrammingCourse(id, name, maxPoints, threshold, pointsToHonors);
                break;
            case MATH:
                course = new MathCourse(id, name, maxPoints, threshold, pointsToHonors);
                break;
            case BIOLOGY:
                course = new BiologyCourse(id, name, maxPoints, threshold, pointsToHonors);
                break;
            case PHYSICS:
                course = new PhysicsCourse(id, name, maxPoints, threshold, pointsToHonors);
                break;
        }

        return course;
    }
}
