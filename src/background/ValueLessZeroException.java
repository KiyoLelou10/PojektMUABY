package background;

public class ValueLessZeroException extends RuntimeException{
	
	public ValueLessZeroException() {
		super();
	}

	public ValueLessZeroException(String attribute) {
		super(attribute+" below zero!");
	};
}
