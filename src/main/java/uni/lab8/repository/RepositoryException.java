package uni.lab8.repository;


/***/
public class RepositoryException extends RuntimeException{
    public RepositoryException(String message) {
        super(message);
    }

    public RepositoryException() {
    }

    public RepositoryException(Throwable cause) {
        super(cause);
    }
}
