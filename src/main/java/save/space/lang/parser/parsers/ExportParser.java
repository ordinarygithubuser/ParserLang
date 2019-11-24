package save.space.lang.parser.parsers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import save.space.lang.common.Parser;
import save.space.lang.common.Stream;
import save.space.lang.common.Token;
import save.space.lang.model.type.Type;
import save.space.lang.parser.ParserException;
import save.space.lang.parser.check.Require;

@Component
public class ExportParser implements Parser<List<Type>> {

	@Autowired
	private TypeParser typeParser;

	@Autowired
	private Require require;

	@Override
	public List<Type> parse(final Stream<Token> stream) throws ParserException {
		final List<Type> types = new ArrayList<>();

		while (stream.hasElements()) {
			require.consumeExports(stream.pop());

			types.add(typeParser.parse(stream));
		}

		return types;
	}

}