package prog.kiev;

import java.util.Comparator;

public class HumanSurnameComparator implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {

        if(o1!=null && o2==null){
            return -1;
        }
        else if(o1==null && o2!=null){
            return 1;
        }
        else if(o1==null && o2==null){
            return 0;
        }

        Human a = (Human) o1;
        Human b = (Human) o2;

        String sName1 = a.getSurname();
        String sName2 = b.getSurname();

        return sName1.compareTo(sName2);
    }
}
