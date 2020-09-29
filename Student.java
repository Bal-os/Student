package prog.kiev;

public class Student extends Human {
    private int studentId;
    private double midMark;

    public Student() {
        super();
    }

    public Student(String name, String surname, Sex sex, int age, int studentId, double midMark) {
        super(name, surname, sex, age);
        this.studentId = studentId;
        this.midMark = midMark;
    }

    public int getStudentId() {
        return studentId;
    }

    public double getMidMark() { return midMark; }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", midMark=" + midMark +
                " " +
                super.toString() +
                '}' ;
    }
}
