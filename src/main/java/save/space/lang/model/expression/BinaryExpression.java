package save.space.lang.model.expression;

public abstract class BinaryExpression implements Expression {

	private final Expression left;

	private final Expression right;

	public BinaryExpression(final Expression left, final Expression right) {
		this.left = left;
		this.right = right;
	}

	public Expression getLeft() {
		return left;
	}

	public Expression getRight() {
		return right;
	}

}
