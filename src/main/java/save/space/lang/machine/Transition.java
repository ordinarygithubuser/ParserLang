package save.space.lang.machine;

public abstract class Transition<I, O> {

	private final State<I, O> targetState;

	private final State<I, O> sourceState;

	public Transition(final State<I, O> sourceState, final State<I, O> targetState) {
		this.sourceState = sourceState;
		this.targetState = targetState;
	}

	public abstract Boolean matches(I input);

	public State<I, O> getSource() {
		return sourceState;
	}

	public State<I, O> getTargetState() {
		return targetState;
	}

}
