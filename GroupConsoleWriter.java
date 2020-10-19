package prog.kiev;

public class GroupConsoleWriter implements GroupWriter {

    public GroupConsoleWriter() {
    }

    @Override
    public void print(Group group) {
        System.out.println(group.toString());
    }
}
