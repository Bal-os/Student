package prog.kiev;

import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

abstract class Group implements Recruite, Serializable {
    public static final int NUMOFSTUDS = 10;
    public static final long serialVersionUID=1L;
    protected String name = new String();

    protected Comparator surnamesCompare = new HumanSurnameComparator();
    protected Comparator marksComparator = new StudentMarksComparator();
    protected Comparator ageComparator = new HumanAgeComparator();

    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }

    protected void checkArray(Student arr[]) throws OutOfGroupException {
        if(arr.length > NUMOFSTUDS) {
            throw new OutOfGroupException("too much students");
        }
    }

    public String getName() {
        return name;
    }

    abstract public int size();

    abstract public void sort();

    abstract public void sortByMarks();

    abstract public void sortByAge();

    abstract public Student find(String surname);

    abstract public boolean delete(int Id);

    abstract public void add(Student newMan);

}
