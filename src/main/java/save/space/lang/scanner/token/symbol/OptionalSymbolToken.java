package save.space.lang.scanner.token.symbol;

import java.util.Optional;

public abstract class OptionalSymbolToken<T> implements SymbolTokenVisitor<Optional<T>> {

	private final Optional<T> defaultValue;

	public OptionalSymbolToken() {
		this.defaultValue = Optional.empty();
	}

	public OptionalSymbolToken(final T element) {
		this.defaultValue = Optional.of(element);
	}

	@Override
	public Optional<T> visit(final AdditionToken additionSymbol) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final AndToken andSymbol) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final AssignmentToken assignmentSymbol) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final CommaToken commaSymbol) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final CurlyBracketsCloseToken curlyBracketsCloseSymbol) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final CurlyBracketsOpenToken curlyBracketsOpenSymbol) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final DivisionToken divisionSymbol) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final DoublecolonToken doublecolonSymbol) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final EdgyBracketCloseToken edgeyBracketsCloseSymbol) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final EdgyBracketOpenToken edgeyBracketsOpenSymbol) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final EqualityToken equalitySymbol) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final GreaterToken greaterSymbol) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final LambdaToken lambdaSymbol) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final OrToken orSymbol) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final MultiplicationToken multiplicationSymbol) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final ParanthesisCloseToken paranthesisCloseSymbol) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final ParanthesisOpenToken paranthesisOpenSymbol) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final PointToken pointSymbol) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final QuoteToken quoteSymbol) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final SemicolonToken semicolonSymbol) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final SmallerToken smallerSymbol) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final SubtractionToken subtractionSymbol) {
		return defaultValue;
	}

}
