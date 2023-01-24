package game.play.eGround.exceptions;

public class AlreadyExistsException extends RuntimeException{

	public AlreadyExistsException(String exception) {
		super(exception);
	}

	public AlreadyExistsException() {
		super();
	}

	public AlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AlreadyExistsException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
	public AlreadyExistsException( Throwable cause)
	{
		super(cause);
	}
}
