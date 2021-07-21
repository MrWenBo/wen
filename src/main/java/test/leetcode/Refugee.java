package test.leetcode;

public class Refugee {
    String name;
    String sex;
    int age;
    int point;

    public Refugee(String name, String sex, int age, int point) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Refugee{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", point=" + point +
                '}';
    }
}
