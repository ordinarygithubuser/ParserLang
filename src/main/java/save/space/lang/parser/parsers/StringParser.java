package save.space.lang.parser.parsers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import save.space.lang.common.Parser;
import save.space.lang.common.Stream;
import save.space.lang.common.Token;
import save.space.lang.parser.ParserException;

@Component
public class StringParser implements Parser<String> {

	@Autowired
	private IdentifierParser identifierParser;

	@Override
	public String parse(final Stream<Token> stream) throws ParserException {
		final String string = identifierParser.parse(stream);

		if (string.indexOf('"') != 0 || string.lastIndexOf('"') != string.length() - 1) {
			throw new ParserException("Invalid String: " + string);
		}

		return string.substring(1, string.length() - 2);
	}

}
