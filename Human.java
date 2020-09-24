package prog.kiev;

enum Sex{
    MALE,
    FEMALE;
}

public class Human {
    private String surname;
    private String name;
    private Sex sex;

    public Human() {
        this.surname = new String();
        this.name = new String();
    }

    public Human(String surname, String name, Sex sex) {
        this.surname = surname;
        this.name = name;
        this.sex = sex;
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

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", sex=" + sex +
                '}';
    }
}
