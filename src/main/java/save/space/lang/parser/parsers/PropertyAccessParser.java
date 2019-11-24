package save.space.lang.parser.parsers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import save.space.lang.common.Parser;
import save.space.lang.common.Stream;
import save.space.lang.common.Token;
import save.space.lang.model.expression.PropertyAccess;
import save.space.lang.parser.ParserException;
import save.space.lang.parser.check.SymbolTokenResolver;

@Component
public class PropertyAccessParser implements Parser<PropertyAccess> {

	@Autowired
	private SymbolTokenResolver symbolResolver;

	@Autowired
	private IdentifierParser identifierParser;

	@Override
	public PropertyAccess parse(final Stream<Token> stream) throws ParserException {
		final var chain = new ArrayList<String>();

		chain.add(identifierParser.parse(stream));

		while (symbolResolver.getPoint(stream.peek()).isPresent()) {
			stream.pop();
			chain.add("." + identifierParser.parse(stream));
		}

		return new PropertyAccess(chain);
	}

}
