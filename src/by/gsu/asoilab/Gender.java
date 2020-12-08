package by.gsu.asoilab;

public enum Gender {
    M ("Male"),
    F ("Female");

    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return gender;
    }
}
