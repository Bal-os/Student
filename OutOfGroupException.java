package prog.kiev;

public class OutOfGroupException extends RuntimeException{

    public OutOfGroupException(String message){

        super(message);
    }

    @Override
    public String getMessage() {
        return "To much students in group";
    }
}

