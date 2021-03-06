package prog.kiev;

import java.io.Serializable;

public class Student extends Human implements Serializable{
    private static final long serialVersionUID = 1L;
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
    public Student(Human human, int studentId, double midMark) {
        super(human.getName(), human.getSurname(), human.getSex(), human.getAge());
        this.studentId = studentId;
        this.midMark = midMark;
    }

    public int getStudentId() {
        return studentId;
    }

    public double getMidMark() { return midMark; }

    @Override
    public String toString() {
        return "Student {\n" +
                super.toString() + '\n' +
                "studentId : " + studentId + '\n' +
                "midMark : " + midMark + '\n' +
                '}' ;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(studentId);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        else if(obj==null) return false;
        else if(this.getClass()!=obj.getClass()) return false;
        Student st = (Student) obj;
        return st.studentId == this.studentId;
    }
}
