package save.space.lang.scanner.state;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import save.space.lang.common.Stream;
import save.space.lang.common.Symbol;
import save.space.lang.common.Token;
import save.space.lang.machine.State;
import save.space.lang.scanner.token.NumberToken;

@Component
public class NumberState extends State<Symbol, Token> {

	@Autowired
	private Matcher matcher;

	@Override
	public boolean matches(final Optional<Symbol> input) {
		return input.isPresent() && matcher.isNumericStart(input.get().getValue());
	}

	@Override
	public Token consume(final Symbol input, final Stream<Symbol> rest) {
		final var valueBuilder = new StringBuilder(input.getValue());
		final var location = input.getLocation();
		var decimalConsumed = false;

		while (matcher.isNumeric(rest, decimalConsumed)) {
			final String current = rest.pop().get().getValue();

			if (current.equals(".")) {
				decimalConsumed = true;
			}

			valueBuilder.append(current);
		}

		final Double value = Double.parseDouble(valueBuilder.toString());

		return new NumberToken(location, value);
	}

}
