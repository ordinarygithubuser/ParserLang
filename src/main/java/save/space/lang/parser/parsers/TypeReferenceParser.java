package save.space.lang.parser.parsers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import save.space.lang.common.Parser;
import save.space.lang.common.Stream;
import save.space.lang.common.Token;
import save.space.lang.model.type.ref.TypeReference;
import save.space.lang.model.type.ref.UnresolvedTypeReference;
import save.space.lang.parser.ParserException;

@Component
public class TypeReferenceParser implements Parser<TypeReference> {

	@Autowired
	private IdentifierParser identifierParser;

	@Autowired
	private GenericTypeParser genericTypeParser;

	@Override
	public TypeReference parse(final Stream<Token> stream) throws ParserException {
		final String name = identifierParser.parse(stream);
		final List<TypeReference> generics = genericTypeParser.parse(stream);

		return new UnresolvedTypeReference(name, generics);
	}
}
