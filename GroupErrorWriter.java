package prog.kiev;

public class GroupErrorWriter implements GroupWriter{
    public GroupErrorWriter() {
    }

    @Override
    public void print(Group group) {
        System.err.println(group.toString());
    }
}
