package game.play.eGround.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String exception) {
		super(exception);
	}

	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ResourceNotFoundException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
	public ResourceNotFoundException( Throwable cause)
	{
		super(cause);
	}
	
}
