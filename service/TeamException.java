package team.service;

public class TeamException extends RuntimeException{
    static final long serialVersionUID = -703489719074576639L;

    public TeamException() {}

    public TeamException(String message) {
        super(message);
    }

    public TeamException(String message, Throwable cause) {
        super(message, cause);
    }
}
