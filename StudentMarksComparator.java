package prog.kiev;

import java.util.Comparator;

public class StudentMarksComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {

        if(o1!=null && o2==null){
            return -1;
        }
        else if(o1==null && o2!=null){
            return 1;
        }
        else if(o1==null && o2==null) {
            return 0;
        }

        Student a = (Student) o1;
        Student b = (Student) o2;

        double mark1 = a.getMidMark();
        double mark2  = b.getMidMark();

        if(mark1 > mark2){
            return 1;
        }
        else if(mark1 < mark2){
            return -1;
        }
        else {
            return 0;
        }
    }
}
