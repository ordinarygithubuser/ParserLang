package save.space.lang.parser.parsers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import save.space.lang.common.Parser;
import save.space.lang.common.Stream;
import save.space.lang.common.Token;
import save.space.lang.model.expression.Expression;
import save.space.lang.model.type.Method;
import save.space.lang.parser.ParserException;
import save.space.lang.parser.check.Require;
import save.space.lang.parser.check.SymbolTokenResolver;

@Component
public class MethodParser implements Parser<Method> {

	@Autowired
	private Require require;

	@Autowired
	private IdentifierParser identifierParser;

	@Autowired
	private AttributeModifierParser attributeModifierParser;

	@Autowired
	private ArgumentsParser argumentsParser;

	@Autowired
	private ExpressionParser expressionParser;

	@Autowired
	private SymbolTokenResolver symbolResolver;

	@Autowired
	private TypeReferenceParser typeReferenceParser;

	@Override
	public Method parse(final Stream<Token> input) throws ParserException {
		final var modifier = attributeModifierParser.parse(input);
		final var identifier = identifierParser.parse(input);
		final var parameters = argumentsParser.parse(input);
		require.consumeDoublecolon(input.pop());
		final var returnType = typeReferenceParser.parse(input);
		final var statements = parseExpressions(input);

		return new Method(modifier, identifier, parameters, statements, returnType);
	}

	private List<Expression> parseExpressions(final Stream<Token> input) throws ParserException {
		final var result = new ArrayList<Expression>();

		require.consumeContextOpen(input.pop());

		while (symbolResolver.getContextClose(input.peek()).isEmpty()) {
			result.add(expressionParser.parse(input));
		}

		require.consumeContextClose(input.pop());

		return result;
	}

}
