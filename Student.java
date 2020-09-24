package prog.kiev;

public class Student extends Human {
    private int studentId;

    public Student() {
        super();
    }

    public Student(String surname, String name, Sex sex, int studentId) {
        super(surname, name, sex);
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student number='" + studentId + '\'' +
                '}' + super.toString();
    }
}
