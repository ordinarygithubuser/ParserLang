package save.space.lang.model.type;

import java.util.ArrayList;
import java.util.Arrays;

import save.space.lang.model.expression.AssignmentExpression;
import save.space.lang.model.expression.Expression;
import save.space.lang.model.expression.PropertyAccess;
import save.space.lang.model.statement.Statement;
import save.space.lang.model.type.ref.TypeReference;

public class Variable implements Statement, AssignmentExpression {

	private final String name;

	private final TypeReference reference;

	private final boolean mutable;

	private final Expression value;

	public Variable(final String name, final TypeReference reference, final boolean mutable, final Expression value) {
		this.name = name;
		this.reference = reference;
		this.mutable = mutable;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public TypeReference getReference() {
		return reference;
	}

	public boolean isMutable() {
		return mutable;
	}

	public Expression getValue() {
		return value;
	}

	@Override
	public PropertyAccess getLefthand() {
		return new PropertyAccess(new ArrayList<>(Arrays.asList(getName())));
	}

	@Override
	public Expression getRighthand() {
		return getValue();
	}

}
