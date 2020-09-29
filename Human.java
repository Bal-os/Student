package prog.kiev;

enum Sex{
    MALE,
    FEMALE;
}

public class Human {
    private String surname;
    private String name;
    private Sex sex;
    private int age;

    public Human() {
        this.surname = new String();
        this.name = new String();
    }

    public Human(String name, String surname, Sex sex, int age) {
        this.surname = surname;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public int getAge() { return age; }


    @Override
    public String toString() {
        return "Human{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
}
