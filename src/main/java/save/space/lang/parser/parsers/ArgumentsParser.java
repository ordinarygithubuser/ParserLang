package save.space.lang.parser.parsers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import save.space.lang.common.Parser;
import save.space.lang.common.Stream;
import save.space.lang.common.Token;
import save.space.lang.model.type.Parameter;
import save.space.lang.parser.ParserException;
import save.space.lang.parser.check.Require;
import save.space.lang.parser.check.SymbolTokenResolver;

@Component
public class ArgumentsParser implements Parser<List<Parameter>> {

	@Autowired
	private Require require;

	@Autowired
	private SymbolTokenResolver symbolResolver;

	@Autowired
	private IdentifierParser identifierParser;

	@Autowired
	private TypeReferenceParser typeReferenceParser;

	@Override
	public List<Parameter> parse(final Stream<Token> stream) throws ParserException {
		final List<Parameter> parameters = new ArrayList<>();
		boolean first = true;

		require.consumeParanthesisOpen(stream.pop());

		while (stream.hasElements() && symbolResolver.getParanthesisClose(stream.peek(0)).isEmpty()) {
			if (first) {
				first = false;
			} else {
				require.consumeComma(stream.pop());
			}

			final var name = identifierParser.parse(stream);
			require.consumeDoublecolon(stream.pop());
			final var type = typeReferenceParser.parse(stream);

			parameters.add(new Parameter(name, type));
		}

		require.consumeParanthesisClose(stream.pop());

		return parameters;
	}

}
