package prog.kiev;

public class InvalidInputExeption extends RuntimeException{
    public InvalidInputExeption(){
        super();
    }
    public InvalidInputExeption(String message){

        super(message);
    }

    @Override
    public String getMessage() {
        return "To much students in group";
    }
}
