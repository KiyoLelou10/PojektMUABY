package background;

/**
* Abstract class forces other classes to override toString and equals.
* 
* @author andrej,yunsee
* @since 1.8
* @version 1.0
*/
public abstract class DroneMethods {
	private String name;
	
	@Override
	public abstract String toString();
	
	@Override
	public abstract boolean equals(Object object);
	
}
