package prog.kiev;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GroupSerializationFileWriter extends GroupFileWriter {
    public GroupSerializationFileWriter() {
        super();
    }

    public GroupSerializationFileWriter(File file) throws IOException {
        super(file);
    }

    public GroupSerializationFileWriter(String fileName) throws IOException {
        super(fileName);
    }

    @Override
    public void print(Group group){
        try (ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(group.toString());
        } catch (IOException e) {
            ///TODO
        }
    }
}
