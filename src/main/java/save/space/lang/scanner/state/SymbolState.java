package save.space.lang.scanner.state;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import save.space.lang.common.Location;
import save.space.lang.common.Stream;
import save.space.lang.common.Symbol;
import save.space.lang.common.Token;
import save.space.lang.machine.MachineException;
import save.space.lang.machine.State;
import save.space.lang.scanner.token.symbol.AdditionToken;
import save.space.lang.scanner.token.symbol.AndToken;
import save.space.lang.scanner.token.symbol.AssignmentToken;
import save.space.lang.scanner.token.symbol.CommaToken;
import save.space.lang.scanner.token.symbol.CurlyBracketsCloseToken;
import save.space.lang.scanner.token.symbol.CurlyBracketsOpenToken;
import save.space.lang.scanner.token.symbol.DivisionToken;
import save.space.lang.scanner.token.symbol.DoublecolonToken;
import save.space.lang.scanner.token.symbol.EdgyBracketCloseToken;
import save.space.lang.scanner.token.symbol.EdgyBracketOpenToken;
import save.space.lang.scanner.token.symbol.EqualityToken;
import save.space.lang.scanner.token.symbol.GreaterToken;
import save.space.lang.scanner.token.symbol.LambdaToken;
import save.space.lang.scanner.token.symbol.MultiplicationToken;
import save.space.lang.scanner.token.symbol.OrToken;
import save.space.lang.scanner.token.symbol.ParanthesisCloseToken;
import save.space.lang.scanner.token.symbol.ParanthesisOpenToken;
import save.space.lang.scanner.token.symbol.PointToken;
import save.space.lang.scanner.token.symbol.QuoteToken;
import save.space.lang.scanner.token.symbol.SemicolonToken;
import save.space.lang.scanner.token.symbol.SmallerToken;
import save.space.lang.scanner.token.symbol.SubtractionToken;
import save.space.lang.scanner.token.symbol.SymbolToken;
import save.space.lang.scanner.token.symbol.SymbolTokens;

@Component
public class SymbolState extends State<Symbol, Token> {

	@Autowired
	private Matcher matcher;

	@Override
	public boolean matches(final Optional<Symbol> input) {
		return input.isPresent() && matcher.isSymbol(input.get().getValue());
	}

	@Override
	public Token consume(final Symbol input, final Stream<Symbol> rest) throws MachineException {
		final var location = input.getLocation();
		final var value = input.getValue();
		final var valueBuilder = new StringBuilder(value);

		if (isMultiCharSymbol(value, rest)) {
			valueBuilder.append(rest.pop().get().getValue());
		}

		final SymbolToken symbol = createSymbol(valueBuilder.toString(), location);

		if (symbol == null) {
			throw new MachineException("Invalid Symbol", this, valueBuilder.toString());
		}

		return symbol;
	}

	private boolean isMultiCharSymbol(final String input, final Stream<Symbol> symbols) {
		final var symbol = symbols.peek();

		return symbol.isPresent() && matcher.isSymbol(input + symbol.get().getValue());
	}

	private SymbolToken createSymbol(final String value, final Location location) {
		switch (value) {
		case SymbolTokens.ADDITION:
			return new AdditionToken(location);
		case SymbolTokens.AND:
			return new AndToken(location);
		case SymbolTokens.ASSIGNMENT:
			return new AssignmentToken(location);
		case SymbolTokens.COMMA:
			return new CommaToken(location);
		case SymbolTokens.CURLY_BRACKETS_OPEN:
			return new CurlyBracketsOpenToken(location);
		case SymbolTokens.CURLY_BRACKETS_CLOSE:
			return new CurlyBracketsCloseToken(location);
		case SymbolTokens.DIVISION:
			return new DivisionToken(location);
		case SymbolTokens.DOUBLECOLON:
			return new DoublecolonToken(location);
		case SymbolTokens.EDGY_BRACKETS_OPEN:
			return new EdgyBracketOpenToken(location);
		case SymbolTokens.EDGY_BRACKETS_CLOSE:
			return new EdgyBracketCloseToken(location);
		case SymbolTokens.EQUALITY:
			return new EqualityToken(location);
		case SymbolTokens.GREATER:
			return new GreaterToken(location);
		case SymbolTokens.LAMBDA:
			return new LambdaToken(location);
		case SymbolTokens.MULTIPLICATION:
			return new MultiplicationToken(location);
		case SymbolTokens.OR:
			return new OrToken(location);
		case SymbolTokens.PARANTHESIS_CLOSE:
			return new ParanthesisCloseToken(location);
		case SymbolTokens.PARANTHESIS_OPEN:
			return new ParanthesisOpenToken(location);
		case SymbolTokens.POINT:
			return new PointToken(location);
		case SymbolTokens.QUOTE:
			return new QuoteToken(location);
		case SymbolTokens.SEMICOLON:
			return new SemicolonToken(location);
		case SymbolTokens.SMALLER:
			return new SmallerToken(location);
		case SymbolTokens.SUBTRACTION:
			return new SubtractionToken(location);
		default:
			return null;
		}
	}

}
