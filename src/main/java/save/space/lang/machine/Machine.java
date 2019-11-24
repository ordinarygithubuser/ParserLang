package save.space.lang.machine;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import save.space.lang.common.Stream;

public abstract class Machine<I, O> {

	private final List<Transition<I, O>> transitions;

	private static final Logger log = LoggerFactory.getLogger(Machine.class);

	public Machine() {
		this.transitions = new ArrayList<>();
	}

	public Stream<O> process(final Stream<I> input) throws MachineException {
		final var output = new Stream<O>();
		var currentState = getStartState();

		while (!input.isEmpty()) {
			final var currentInput = input.pop().get();
			final var transition = getTransition(currentState, currentInput);

			if (transition.isPresent()) {
				currentState = transition.get().getTargetState();
				final O element = step(currentState, currentInput, input);

				log.info("State {} produced {}.", currentState, element);

				output.push(element);
			} else {
				throw new MachineException("No transition found", currentState, currentInput);
			}
		}

		return output;
	}

	public void addTransition(final State<I, O> source, final State<I, O> target, final Function<I, Boolean> matcher) {
		transitions.add(new Transition<>(source, target) {
			public Boolean matches(final I input) {
				return matcher.apply(input);
			}
		});
	}

	protected abstract State<I, O> getStartState();

	protected abstract boolean isLineEnd(I input);

	private Optional<Transition<I, O>> getTransition(final State<I, O> state, final I currentInput) {
		return transitions.stream().filter(t -> t.getSource().equals(state) && t.matches(currentInput)).findFirst();
	}

	protected O step(final State<I, O> state, final I input, final Stream<I> rest) throws MachineException {
		return state.consume(input, rest);
	}

}
