package save.space.lang.parser.parsers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import save.space.lang.common.Parser;
import save.space.lang.common.Stream;
import save.space.lang.common.Token;
import save.space.lang.model.type.ref.ExternalTypeRerence;
import save.space.lang.parser.ParserException;
import save.space.lang.parser.check.KeywordTokenResolver;
import save.space.lang.parser.check.Require;

@Component
public class ImportsParser implements Parser<List<ExternalTypeRerence>> {

	@Autowired
	private KeywordTokenResolver keywordResolver;

	@Autowired
	private Require require;

	@Autowired
	private IdentifierParser identifierParser;

	@Autowired
	private StringParser stringParser;

	@Override
	public List<ExternalTypeRerence> parse(final Stream<Token> stream) throws ParserException {
		final List<ExternalTypeRerence> references = new ArrayList<>();

		while (keywordResolver.getImport(stream.peek()).isPresent()) {
			stream.pop();
			references.add(parseExternalTypeReference(stream));
		}

		return references;
	}

	private ExternalTypeRerence parseExternalTypeReference(final Stream<Token> stream) throws ParserException {
		final String name = identifierParser.parse(stream);
		require.consumeFrom(stream.pop());
		final String path = stringParser.parse(stream);
		require.consumeSemicolon(stream.pop());

		return new ExternalTypeRerence(name, path);
	}

}