package team.view;

public class OutOfBoundException extends Exception{
    static final long serialVersionUID = -3387516993124229948L;

    public OutOfBoundException() {
    }

    public OutOfBoundException(String message) {
        super(message);
    }

    public OutOfBoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
