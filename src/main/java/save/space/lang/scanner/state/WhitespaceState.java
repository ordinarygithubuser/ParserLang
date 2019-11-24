package save.space.lang.scanner.state;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import save.space.lang.common.Stream;
import save.space.lang.common.Symbol;
import save.space.lang.common.Token;
import save.space.lang.machine.State;
import save.space.lang.scanner.token.WhitespaceToken;

@Component
public class WhitespaceState extends State<Symbol, Token> {

	@Autowired
	private Matcher matcher;

	@Override
	public boolean matches(final Optional<Symbol> symbol) {
		return symbol.isPresent() && matcher.isWhitespace(symbol.get().getValue());
	}

	@Override
	public Token consume(final Symbol input, final Stream<Symbol> rest) {
		return new WhitespaceToken(input.getLocation(), input.getValue());
	}

}
