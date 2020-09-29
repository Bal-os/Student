package prog.kiev;

import java.util.Comparator;

public class HumanAgeComparator implements Comparator {

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

            int age1 = a.getAge();
            int age2 = b.getAge();

            if(age1 < age2){
                return 1;
            }
            else if(age1 > age2){
                return -1;
            }
            else {
                return 0;
            }
        }
    }

