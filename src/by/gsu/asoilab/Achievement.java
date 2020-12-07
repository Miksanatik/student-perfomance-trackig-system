package by.gsu.asoilab;

public class Achievement {
    private int id;
    private String name;
    private int points;
    private int testNo;
    private int courseId;

    public static class Builder {
        private Achievement achievement;

        public Builder() {
            achievement = new Achievement();
        }

        public Builder setId(int id) {
            achievement.id = id;
            return this;
        }

        public Builder setName(String name) {
            achievement.name = name;
            return this;
        }

        public Builder setPoints(int points) {
            achievement.points = points;
            return this;
        }

        public Builder setTestNo(int testNo) {
            achievement.testNo = testNo;
            return this;
        }

        public Builder setCourseId(int courseId) {
            achievement.courseId = courseId;
            return this;
        }

        public Achievement build() {
            return achievement;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getTestNo() {
        return testNo;
    }

    public int getCourseId() {
        return courseId;
    }

    @Override
    public String toString() {
        return String.format("%d;%s;%d;%d;%d", id, name, points, testNo, courseId);
    }
}
