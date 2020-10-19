package prog.kiev;

import java.io.*;

public class main {
    private static void test(){
        Human person = new Human("Tom", "White", Sex.MALE, 14);
        //System.out.println(person);

        Student[] studList = new Student[8];
        for(int i=0;i<studList.length;i++){
            studList[i] = new Student("name"+i,"surname"+i,Sex.MALE, i + 16, 123+i,
                    (double) i%2 > 0 ? (60 + 10 * i) / 2 : 40 / (i+1) + 60);
        }

		/*for(Student student: studList){
			System.out.println(student);
		}*/


        Group DO = new Group("DO-3");
        try {
            for (int i = 0; i < studList.length; i++) {
                DO.add(studList[i]);
            }
        }catch (OutOfGroupException e){
            System.out.println(e.getMessage());
        }

        Group gg = new Group("qq");
        HumansReader aa = new HumansConsoleReader();
        gg = aa.read(new Group());
        GroupWriter gw = new GroupConsoleWriter();
        gw.print(gg);


        try {
            System.out.println(DO);
            System.out.println();
            DO.delete(124);
            System.out.println(DO);
                       System.out.println(DO.find("surname5") + "\n");
        }catch (OutOfGroupException e)
        {
            System.out.println(e.getMessage());
        }

        Student st1 = new Student("Vasya", "Antonov",Sex.MALE, 22, 1234, 123);
        Student st2 = new Student("Petya", "Ptushkin",Sex.MALE, 18,  1234, 32);
        Student st3 = new Student("Anton", "Sidorov", Sex.MALE,16, 1234, 77);
        try {
            DO.add(st1);
            DO.add(st2);
            DO.add(st3);
            //group.addNewStudentKeyboard();
        } catch (OutOfGroupException e) {
            System.out.println(e.getMessage());
        }
        DO.sortByAge();
        System.out.println(DO);
        for (Student student: DO.mobilize()){
            System.out.println(student.toString());
        }
    }


    public static void main(String[] args) {
        test();
    }
}

