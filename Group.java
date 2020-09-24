package prog.kiev;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.Arrays;

public class Group {
    private static final int NumOfStudents = 10;
    private Comparator<Student> comparator = Comparator.comparing(obj -> obj.getSurname());
    Student arr[];
    String name;
    int count = 0;

    public Group(String name, Student ... arr) throws OutOfGroupException{
        this.arr = new Student[NumOfStudents];
        if(arr.length > 0) arr = Arrays.copyOf(arr, arr.length);
        this.name = name;
    }

    private Student[] checkArray(Student arr[]) throws OutOfGroupException {
        if(arr.length > NumOfStudents) throw new OutOfGroupException("123");
        count = arr.length;
        Arrays.sort(arr,comparator);
        return arr;
    }

    public String getName() {
        return name;
    }

    public Student find(String surname){
        for(int i = 0; i < count; i++)
        {
            if(arr[i].getSurname().equals(surname))
                return arr[i];
        }
        return null;
    }

    public boolean delete(int Id){
        for(int i = 0; i < NumOfStudents; i++)
        {
            if(arr[i].getStudentId() == Id)
            {
                arr[i] = new Student();
                Arrays.sort(arr,comparator);
                count--;
            }
            return true;
        }
        return false;
    }

    public void Add(Student newMan) throws OutOfGroupException{
        if(count >= NumOfStudents) throw new OutOfGroupException("");
        arr[count] = newMan;
        count++;
    }

    @Override
    public String toString() {
        String ans = "";
        for (int i = 0; i < count; i++) {
            ans += arr[i].toString() + '\n';
        }
        return ans;
    }
}
