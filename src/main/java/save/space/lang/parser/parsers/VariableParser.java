package save.space.lang.parser.parsers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import save.space.lang.common.Parser;
import save.space.lang.common.Stream;
import save.space.lang.common.Token;
import save.space.lang.model.type.Variable;
import save.space.lang.model.type.ref.DerivedTypeReference;
import save.space.lang.model.type.ref.TypeReference;
import save.space.lang.parser.ParserException;
import save.space.lang.parser.check.KeywordTokenResolver;
import save.space.lang.parser.check.Require;
import save.space.lang.parser.check.SymbolTokenResolver;

@Component
public class VariableParser implements Parser<Variable> {

	@Autowired
	private Require require;

	@Autowired
	private KeywordTokenResolver keywordResolver;

	@Autowired
	private SymbolTokenResolver symbolResolver;

	@Autowired
	private IdentifierParser identifierParser;

	@Autowired
	private ExpressionParser expressionParser;

	@Autowired
	private TypeReferenceParser typeReferenceParser;

	@Override
	public Variable parse(final Stream<Token> input) throws ParserException {
		final var token = input.pop();
		final var var = keywordResolver.getVar(token);
		final var val = keywordResolver.getVal(token);

		if (var.isEmpty() && val.isEmpty()) {
			throw new ParserException("Expected var or val  but got", token);
		}

		final var mutable = var.isPresent();
		final var name = identifierParser.parse(input);
		final var type = parseTypeReference(input);
		require.consumeAssignment(input.pop());
		final var expression = expressionParser.parse(input);

		return new Variable(name, type, mutable, expression);
	}

	private TypeReference parseTypeReference(final Stream<Token> input) throws ParserException {
		if (symbolResolver.getDoublecolon(input.peek()).isPresent()) {
			input.pop();

			return typeReferenceParser.parse(input);
		}

		return new DerivedTypeReference();
	}

}
