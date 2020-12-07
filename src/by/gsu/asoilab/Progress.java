package by.gsu.asoilab;

import java.util.Arrays;

public class Progress {
    private int studentId;
    private int courseId;
    private int[] controlPoints;

    public static class Builder {
        Progress progress;

        public Builder() {
            progress = new Progress();
        }

        public Builder setStudentId(int studentId) {
            progress.studentId = studentId;
            return this;
        }

        public Builder setCourseId(int courseId) {
            progress.courseId = courseId;
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

    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public int[] getControlPoints() {
        return controlPoints;
    }

    @Override
    public String toString() {
        return String.format("%d;%d;%s", studentId, courseId, Arrays.toString(controlPoints));
    }
}
