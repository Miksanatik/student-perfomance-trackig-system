package by.gsu.asoilab;

public class Achievement {
    private int id;
    private String name;
    private int requiredPoints;
    private int testNo;
    private int earnedPoints;

    public static class Builder {
        private final Achievement achievement;

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

        public Builder setRequiredPoints(int requiredPoints) {
            achievement.requiredPoints = requiredPoints;
            return this;
        }

        public Builder setTestNo(int testNo) {
            achievement.testNo = testNo;
            return this;
        }

        public Builder setEarnedPoints(int earnedPoints) {
            achievement.earnedPoints = earnedPoints;
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

    public int getRequiredPoints() {
        return requiredPoints;
    }

    public int getTestNo() {
        return testNo;
    }

    public int getEarnedPoints() {
        return earnedPoints;
    }

    @Override
    public String toString() {
        return String.format("%d;%s;%d;%d;%d", id, name, requiredPoints, testNo, earnedPoints);
    }
}
