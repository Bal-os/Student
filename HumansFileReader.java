package prog.kiev;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class HumansFileReader implements HumansReader{
    protected File file;

    public HumansFileReader() {
    }

    public HumansFileReader(File file) throws IOException {
        if(file.exists()){
            this.file = file;
        }
        else{
            this.file.createNewFile();
        }
    }

    public HumansFileReader(String fileName) throws IOException {
        file = new File(fileName);
        if(!file.exists()){
            file.createNewFile();
        }
    }

    private String parseLine(String str){
        return str.substring(str.indexOf(":") + 1);
    }

    @Override
    public Human read(Human human) {
        try (Scanner input = new Scanner(file)) {
            String name = parseLine(input.next());
            String surname = parseLine(input.next());
            Sex sex = Sex.valueOf(parseLine(input.next()).toUpperCase());
            int age = Integer.parseInt(parseLine(input.next()));
            human = new Human(name, surname, sex, age);
        } catch (FileNotFoundException e) {}
        return human;
    }

    @Override
    public Student read(Student student) {
        try (Scanner input = new Scanner(file)) {
            int id = Integer.parseInt(parseLine(input.next()));
            double midMark = Double.valueOf(parseLine(input.next()));
            input.next();
            student = new Student(read(new Human()), id, midMark);
        } catch (FileNotFoundException e) {}
        return student;
    }

    @Override
    public Group read(Group group) {
        try (Scanner input = new Scanner(file)) {
            input.next();
            String name = parseLine(input.next());
            group = new ArrayGroup(name);
            String s;
            while((s = input.next()) != null){
                if(s.equals("{")) break;
                group.add(read(new Student()));
                if(group.size() == Group.NUMOFSTUDS) break;
                input.next();
                input.next();
            }
        } catch (FileNotFoundException e) {}
        return group;
    }
}
