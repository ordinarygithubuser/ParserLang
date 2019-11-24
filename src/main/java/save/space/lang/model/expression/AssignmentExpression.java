package save.space.lang.model.expression;

public interface AssignmentExpression extends Expression {

	PropertyAccess getLefthand();

	Expression getRighthand();

}
