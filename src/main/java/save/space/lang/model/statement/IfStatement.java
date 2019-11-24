package save.space.lang.model.statement;

import java.util.List;

import save.space.lang.model.expression.Expression;

public class IfStatement implements Statement {

	private final Expression condition;

	private final List<Statement> body;

	public IfStatement(final Expression condition, final List<Statement> body) {
		this.condition = condition;
		this.body = body;
	}

	public Expression getCondition() {
		return condition;
	}

	public List<Statement> getBody() {
		return body;
	}
}
