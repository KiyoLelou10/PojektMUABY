package background;

/**
* Class for exception if a list is empty. 
* 
* @author andrej,yunsee
* @version 1.0
*/
public class ListIsEmptyException extends RuntimeException {
	
	public ListIsEmptyException() {
		super("This list is empty, therefore, this action is meaningless");
	}
	
}
