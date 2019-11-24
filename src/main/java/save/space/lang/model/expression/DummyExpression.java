package save.space.lang.model.expression;

import save.space.lang.common.Stream;
import save.space.lang.common.Token;

public class DummyExpression implements Expression {

	private final Stream<Token> value;

	public DummyExpression(final Stream<Token> value) {
		this.value = value;
	}

	public Stream<Token> getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "DummyExpression(" + value.toString() + ")";
	}

}
