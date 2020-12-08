package by.gsu.asoilab.courses;

public enum CourseCategories {
    PROGRAMMING("Programming"),
    MATH("Math"),
    BIOLOGY("Biology"),
    PHYSICS("Physics");

    private String course;

    CourseCategories(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return course;
    }
}
