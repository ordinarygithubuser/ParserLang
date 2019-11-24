package save.space.lang.model.expression;

import java.util.List;

import save.space.lang.model.type.ref.TypeReference;

public class Invocation implements Expression {

	private final TypeReference context;

	private final List<Expression> arguments;

	public Invocation(final TypeReference context, final List<Expression> arguments) {
		this.context = context;
		this.arguments = arguments;
	}

	public TypeReference getContext() {
		return context;
	}

	public List<Expression> getArguments() {
		return arguments;
	}

}
