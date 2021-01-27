package prog.kiev;

import java.util.*;
import java.util.function.Consumer;

public class GroupCollection extends Group
{
    public static final long serialVersionUID=1L;
    List<Student> arr = new ArrayList<Student>(NUMOFSTUDS);
    String name = new String();

    private Comparator surnamesCompare = new HumanSurnameComparator();
    private Comparator marksComparator = new StudentMarksComparator();
    private Comparator ageComparator = new HumanAgeComparator();
    public GroupCollection() {
    }

    public GroupCollection(String name) {
        this.name = name;
    }

    public GroupCollection(String name, Student ... arr) throws OutOfGroupException{
        if(arr.length > 0) {
            checkArray(arr);
            this.arr = Arrays.asList(arr);
        }
        this.name = name;
    }

    public int size() {return arr.size();}

    public void sort(){
        arr.sort(surnamesCompare);
    }

    public void sortByMarks(){
        arr.sort(marksComparator);
    }

    public void sortByAge(){
        arr.sort(ageComparator);
    }

    public Student find(String surname){
        for(var i:arr) {
            if (i.getSurname().equalsIgnoreCase(surname)) {
                return i;
            }
        }
        return null;
    }

    public boolean delete(int Id){
        Student cur;
        for(int i = 0; i < arr.size(); i++){
            cur = cur = arr.get(i);
            if(cur.getStudentId() == Id){
                return arr.remove(cur);
            }
        }
        return false;
    }

    public void add(Student newMan) throws OutOfGroupException{
        if(arr.size() >= NUMOFSTUDS) {throw new OutOfGroupException("group is full");}
        arr.add(newMan);
        this.sort();
    }

    @Override
    public Student[] mobilize() {
        List<Student> ans = new ArrayList<Student>();
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
        String ans = "Group {\n" +
                "name : " + this.name + '\n';
        for (var i: arr) {
            ans += i.toString() + '\n';
        }
        ans += '}';
        return ans;
    }
}
