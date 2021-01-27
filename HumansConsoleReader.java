package prog.kiev;

import java.util.Scanner;

public class HumansConsoleReader implements HumansReader{
    public HumansConsoleReader() {
    }

    @Override
    public Human read(Human human) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter name");
        String name = input.next();
        System.out.println("Enter surname");
        String surname = input.next();
        System.out.println("Enter sex");
        Sex sex = Sex.valueOf(input.next().toUpperCase());
        System.out.println("Enter age");
        int age = Integer.parseInt(input.next());
        return new Human(name, surname, sex, age);
    }

    @Override
    public Student read(Student student) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Student id");
        int id = Integer.parseInt(input.next());
        System.out.println("Enter student midle mark");
        double midMark = Double.valueOf(input.next());
        return new Student(read(new Human()), id, midMark);
    }

    @Override
    public Group read(Group group) {
        Scanner input = new Scanner(System.in);
        int size = 0;
        boolean flag = true;
        do {
            System.out.println("Enter number of students");
            size = Integer.parseInt(input.next());
            if(size < 0) {
                System.out.println("Number of students should be not negative");
            }
            else {
                if (group.size() + size > Group.NUMOFSTUDS) {
                    if (size > Group.NUMOFSTUDS) {
                        System.out.println("Too much students");
                    }
                    else {
                        System.out.println("Enter name of group");
                        String name = input.next();
                        group = new ArrayGroup(name);
                        flag = false;
                    }
                }
                else flag = false;
            }
        } while (flag);
        for (int i = 0; i < size; i++) {
            group.add(read(new Student()));
        }
        return group;
    }
}
