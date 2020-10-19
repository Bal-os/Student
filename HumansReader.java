package prog.kiev;

public interface HumansReader {
    public abstract Human read(Human human);
    public abstract Student read(Student student);
    public abstract Group read(Group group);
}
