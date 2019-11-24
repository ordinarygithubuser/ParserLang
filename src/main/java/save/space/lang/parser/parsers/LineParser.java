package save.space.lang.parser.parsers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import save.space.lang.common.Parser;
import save.space.lang.common.Stream;
import save.space.lang.common.Token;
import save.space.lang.parser.ParserException;
import save.space.lang.parser.check.Require;
import save.space.lang.parser.check.SymbolTokenResolver;

@Component
public class LineParser implements Parser<Stream<Token>> {

	@Autowired
	private Require require;

	@Autowired
	private SymbolTokenResolver symbolResolver;

	@Override
	public Stream<Token> parse(final Stream<Token> stream) throws ParserException {
		final var slice = new Stream<Token>();

		while (stream.hasElements() && symbolResolver.getLineEnd(stream.peek()).isEmpty()) {
			slice.unshift(stream.pop().get());
		}

		require.consumeSemicolon(stream.pop());

		return slice;
	}

}
