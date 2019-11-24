package save.space.lang.model.expression;

public class PropertyAssignment implements AssignmentExpression {

	private final PropertyAccess access;

	private final Expression value;

	public PropertyAssignment(final PropertyAccess access, final Expression value) {
		this.access = access;
		this.value = value;
	}

	@Override
	public PropertyAccess getLefthand() {
		return access;
	}

	@Override
	public Expression getRighthand() {
		return value;
	}

}
