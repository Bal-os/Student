package prog.kiev;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;

public class Group implements Recruite{
    private static final int NUMOFSTUDS = 10;
    Student arr[] = new Student[NUMOFSTUDS];
    String name;
    int count = 0;

    private Comparator surnamesCompare = new HumanSurnameComparator();
    private Comparator marksComparator = new StudentMarksComparator();
    private Comparator ageComparator = new HumanAgeComparator();

    public Group(String name, Student ... arr) throws OutOfGroupException{
        if(arr.length > 0) {
            checkArray(arr);
            this.arr = Arrays.copyOf(arr, arr.length);
            count = arr.length;
        }
        this.name = name;
    }

    private void checkArray(Student arr[]) throws OutOfGroupException {
        if(arr.length > NUMOFSTUDS) {
            throw new OutOfGroupException("too much students");
        }
    }

    public void sort(){
        Arrays.sort(arr, surnamesCompare);
    }

    public void sortByMarks(){
        Arrays.sort(arr, marksComparator);
    }

    public void sortByAge(){
        Arrays.sort(arr, ageComparator);
    }

    public String getName() {
        return name;
    }

    public Student find(String surname){
        for(int i = 0; i < count; i++) {
            if (arr[i].getSurname().equalsIgnoreCase(surname)) {
                return arr[i];
            }
        }
        return null;
    }

    public boolean delete(int Id){
        for(int i = 0; i < count; i++)
        {
            if(arr[i].getStudentId() == Id)
            {
                arr[i] = null;
                this.sort();
                count--;
                return true;
            }
        }
        return false;
    }

    public void add(Student newMan) throws OutOfGroupException{
        if(count >= NUMOFSTUDS) {throw new OutOfGroupException("group is full");}
        arr[count] = newMan;
        this.sort();
        count++;
    }

    @Override
    public Student[] mobilize() {
        ArrayList<Student> ans = new ArrayList<Student>();
        this.sortByAge();
        for(Student i: arr){
            if(i.getAge() < 18){
                break;
            }
            if(i.getSex() == Sex.MALE){
                ans.add(i);
            }
        }
        return ans.toArray(new Student[ans.size()]);
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
