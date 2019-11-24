package save.space.lang.parser.parsers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import save.space.lang.common.Parser;
import save.space.lang.common.Stream;
import save.space.lang.common.Token;
import save.space.lang.model.type.ref.TypeReference;
import save.space.lang.parser.ParserException;
import save.space.lang.parser.check.Require;
import save.space.lang.parser.check.SymbolTokenResolver;

@Component
public class GenericTypeParser implements Parser<List<TypeReference>> {

	@Autowired
	private Require require;

	@Autowired
	private SymbolTokenResolver symbolResolver;

	@Autowired
	private TypeReferenceParser typeReferenceParser;

	@Override
	public List<TypeReference> parse(final Stream<Token> stream) throws ParserException {
		final var types = new ArrayList<TypeReference>();
		boolean first = true;

		if (symbolResolver.getEdgyBracketOpen(stream.peek()).isPresent()) {
			stream.pop();

			while (stream.hasElements() && symbolResolver.getEdgyBracketClose(stream.peek()).isEmpty()) {
				if (first) {
					first = false;
				} else {
					require.consumeComma(stream.pop());
				}

				types.add(typeReferenceParser.parse(stream));
			}

			if (first) {
				throw new ParserException("Generic Type Arguments are missing");
			}

			require.consumeEdgyBracketClose(stream.pop());
		}

		return types;
	}

}
