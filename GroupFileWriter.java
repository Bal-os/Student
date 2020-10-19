package prog.kiev;

import java.io.*;

public class GroupFileWriter implements GroupWriter{
    protected File file;

    public GroupFileWriter() {
    }

    public GroupFileWriter(File file) throws IOException{
        if(file.exists()){
            this.file = file;
        }
        else{
            this.file.createNewFile();
        }
    }

    public GroupFileWriter(String fileName) throws IOException {
        file = new File(fileName);
        if(!file.exists()){
            file.createNewFile();
        }
    }

    @Override
    public void print(Group group) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(group.toString());
        } catch (IOException e) {
            ///TODO
        }
    }
}
