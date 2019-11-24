package save.space.lang.model.type;

import java.util.List;

import save.space.lang.model.expression.Expression;
import save.space.lang.model.type.ref.TypeReference;

public class Method implements Any {

	private final AttributeModifier modifier;

	private final String name;

	private final List<Parameter> parameters;

	private final List<Expression> statements;

	private final TypeReference returnType;

	public Method(final AttributeModifier modifier, final String name, final List<Parameter> parameters,
			final List<Expression> statements, final TypeReference returnType) {
		this.modifier = modifier;
		this.name = name;
		this.parameters = parameters;
		this.statements = statements;
		this.returnType = returnType;
	}

	public AttributeModifier getModifier() {
		return modifier;
	}

	public String getName() {
		return name;
	}

	public List<Parameter> getParameters() {
		return parameters;
	}

	public List<Expression> getStatements() {
		return statements;
	}

	public TypeReference getReturnType() {
		return returnType;
	}

}
