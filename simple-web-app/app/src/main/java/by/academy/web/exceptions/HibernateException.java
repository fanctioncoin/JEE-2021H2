package by.academy.web.exceptions;

public class HibernateException extends ApplicationException {
    public HibernateException(String message) {
        super(message);
    }

    public HibernateException(String message, Throwable cause) {
        super(message, cause);
    }

    public HibernateException(Throwable cause) {
        super(cause);
    }
}
