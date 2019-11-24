package save.space.lang.scanner.token.symbol;

public interface SymbolTokenVisitor<T> {

	T visit(AdditionToken additionSymbol);

	T visit(AndToken andSymbol);

	T visit(AssignmentToken assignmentSymbol);

	T visit(CommaToken commaSymbol);

	T visit(CurlyBracketsCloseToken curlyBracketsCloseSymbol);

	T visit(CurlyBracketsOpenToken curlyBracketsOpenSymbol);

	T visit(DivisionToken divisionSymbol);

	T visit(DoublecolonToken doublecolonSymbol);

	T visit(EdgyBracketCloseToken edgeyBracketsCloseSymbol);

	T visit(EdgyBracketOpenToken edgeyBracketsOpenSymbol);

	T visit(EqualityToken equalitySymbol);

	T visit(GreaterToken greaterSymbol);

	T visit(LambdaToken lambdaSymbol);

	T visit(OrToken orSymbol);

	T visit(MultiplicationToken multiplicationSymbol);

	T visit(ParanthesisCloseToken paranthesisCloseSymbol);

	T visit(ParanthesisOpenToken paranthesisOpenSymbol);

	T visit(PointToken pointSymbol);

	T visit(QuoteToken quoteSymbol);

	T visit(SemicolonToken semicolonSymbol);

	T visit(SmallerToken smallerSymbol);

	T visit(SubtractionToken subtractionSymbol);

}
