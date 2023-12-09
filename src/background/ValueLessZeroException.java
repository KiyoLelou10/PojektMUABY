package background;

public class ValueLessZeroException extends RuntimeException{
	

	public ValueLessZeroException(String attr) {
		super(attr+" below zero! ");
	};
	
	
}
