package save.space.lang.model.statement;

import save.space.lang.model.expression.Expression;

public class ReturnStatement implements Statement {

	private final Expression expression;

	public ReturnStatement(final Expression expression) {
		this.expression = expression;
	}

	public Expression getExpression() {
		return expression;
	}

}
