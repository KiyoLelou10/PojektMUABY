package background;

/**
* Exception class thrown if certain values are less than zero.
* 
* @author Andrej, Yunsee
* @version 1.0
*/
public class ValueLessZeroException extends RuntimeException{
	
	public ValueLessZeroException() {
		super();
	}

	public ValueLessZeroException(String attribute) {
		super(attribute+" below zero!");
	}
	
}
