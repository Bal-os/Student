package prog.kiev;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class HumansSerializationFileReader extends HumansFileReader {
    public HumansSerializationFileReader() {
    }

    public HumansSerializationFileReader(File file) throws IOException {
        super(file);
    }

    public HumansSerializationFileReader(String fileName) throws IOException {
        super(fileName);
    }

    private <T> T read(T obj){
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))){

            obj = (T)inputStream.readObject();

        }catch (IOException | ClassNotFoundException e){
        }
        return (T)obj;
    }

    @Override
    public Human read(Human human) {
       return read(human);
    }

    @Override
    public Student read(Student student) {
        return read(student);
    }

    @Override
    public Group read(Group group) {
        return read(group);
    }
}
