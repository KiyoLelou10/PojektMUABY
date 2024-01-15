package background;

public class ListIsEmptyException extends RuntimeException {
	public ListIsEmptyException() {
		
		super("This list is empty, therefore, this action is meaningless");
	}

	
}
