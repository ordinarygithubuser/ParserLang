package save.space.lang.parser.parsers;

import java.util.Optional;

import org.springframework.stereotype.Component;

import save.space.lang.common.Parser;
import save.space.lang.common.Stream;
import save.space.lang.common.Token;
import save.space.lang.parser.ParserException;
import save.space.lang.scanner.token.DefaultTokenVisitor;
import save.space.lang.scanner.token.IdentifierToken;

@Component
public class IdentifierParser implements Parser<String> {

	@Override
	public String parse(final Stream<Token> input) throws ParserException {
		final Optional<Token> token = input.pop();

		if (token.isPresent()) {
			final String identifier = token.get().accept(new DefaultTokenVisitor<>("") {
				@Override
				public String visit(final IdentifierToken identifierToken) {
					return identifierToken.getIdentifier();
				}
			});

			return identifier;

		}

		throw new ParserException("Expected identifier but got", token);
	}

}
