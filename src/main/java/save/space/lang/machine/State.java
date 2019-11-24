package save.space.lang.machine;

import java.util.Optional;

import save.space.lang.common.Stream;

public abstract class State<I, O> {

	public abstract boolean matches(Optional<I> input);

	public abstract O consume(I input, Stream<I> rest) throws MachineException;

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}

}
