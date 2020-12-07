package by.gsu.asoilab;

public class Student {
    private int id;
    private String nickname;
    private String country;
    private Gender gender;
    private int age;

    public static class Builder {
        private Student student;

        public Builder() {
            student = new Student();
        }

        public Builder setId(int id) {
            student.id = id;
            return this;
        }

        public Builder setNickname(String nickname) {
            student.nickname = nickname;
            return this;
        }

        public Builder setCountry(String country) {
            student.country = country;
            return this;
        }

        public Builder setGender(Gender gender) {
            student.gender = gender;
            return this;
        }

        public Builder setAge(int age) {
            student.age = age;
            return this;
        }

        public Student build() {
            return student;
        }
    }

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getCountry() {
        return country;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%d;%s;%s;%s;%d", id, nickname, country, gender, age);
    }
}
