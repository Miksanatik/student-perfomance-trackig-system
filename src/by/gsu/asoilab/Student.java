package by.gsu.asoilab;

public class Student {
    private int id;
    private String nickname;
    private String country;
    private int age;
    private String gender;

    public Student() {
    }

    public Student(int id, String nickname, String country, int age, String gender) {
        this.id = id;
        this.nickname = nickname;
        this.country = country;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}