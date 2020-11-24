package by.gsu.asoilab;

public class Student {
    private int id;
    private String nickname;
    private String country;
    private int age;

    public Student() {
    }

    public Student(int id, String nickname, String country, int age) {
        this.id = id;
        this.nickname = nickname;
        this.country = country;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%d;%s;%s;%d", id, nickname, country, age);
    }
}
