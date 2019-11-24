package save.space.lang.machine;

public class MachineException extends Exception {

	private static final long serialVersionUID = -5532167300522364734L;

	public MachineException(final String message, final State<?, ?> state, final Object input) {
		super("Message: " + message + ", State:" + state + ", Input: " + input);
	}

}
