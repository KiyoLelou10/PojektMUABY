package background;

public class ValueLessZeroException extends RuntimeException{
	
	public ValueLessZeroException() {
		super();
	}

	public ValueLessZeroException(String attr) {
		super(attr+" below zero! ");
	};
	
	
}
