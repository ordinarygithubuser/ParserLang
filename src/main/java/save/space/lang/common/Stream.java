package save.space.lang.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Stream<T> {

	private final List<T> elements;

	public Stream() {
		this.elements = new ArrayList<>();
	}

	public Stream(final List<T> elements) {
		this.elements = elements;
	}

	public Stream(final T element) {
		this.elements = new ArrayList<>();
		this.push(element);
	}

	public void push(final T element) {
		this.elements.add(0, element);
	}

	public void unshift(final T element) {
		this.elements.add(element);
	}

	public Optional<T> pop() {
		if (this.isEmpty()) {
			return Optional.empty();
		}

		return Optional.of(this.elements.remove(0));
	}

	public Optional<T> peek(final int index) {
		if (this.elements.size() <= index) {
			return Optional.empty();
		}

		return Optional.of(this.elements.get(index));
	}

	public Optional<T> peek() {
		return peek(0);
	}

	public Stream<T> slice(final Function<T, Boolean> condition) {
		final Stream<T> result = new Stream<>();

		while (hasElements()) {
			final T element = pop().get();

			result.push(element);

			if (condition.apply(element)) {
				return result;
			}
		}

		return result;
	}

	public void forEach(final Consumer<T> consumer) {
		elements.forEach(element -> consumer.accept(element));
	}

	public Stream<T> filter(final Predicate<T> condition) {
		final var result = new Stream<T>();

		elements.forEach(element -> {
			if (condition.test(element)) {
				result.push(element);
			}
		});

		return result;
	}

	public Stream<T> reverse() {
		final var result = new Stream<T>();

		forEach(element -> result.unshift(element));

		return result;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean hasElements() {
		return !isEmpty();
	}

	public Integer size() {
		return this.elements.size();
	}

	@Override
	public String toString() {
		final String elementsString = elements.stream().map(e -> e.toString() + ", ").reduce("", (agg, e) -> agg + e);

		return "Stream(" + elementsString + ")";
	}

}
