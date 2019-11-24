package save.space.lang.parser.parsers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import save.space.lang.common.Parser;
import save.space.lang.common.Stream;
import save.space.lang.common.Token;
import save.space.lang.model.expression.Expression;
import save.space.lang.model.expression.PropertyAccess;
import save.space.lang.parser.ParserException;
import save.space.lang.parser.check.KeywordTokenResolver;
import save.space.lang.parser.check.SymbolTokenResolver;

@Component
public class ExpressionParser implements Parser<Expression> {

	@Autowired
	private KeywordTokenResolver keywordResolver;

	@Autowired
	private SymbolTokenResolver symbolResolver;

	@Autowired
	private VariableParser variableParser;

	@Autowired
	private PropertyAccessParser propertyAccessParser;

	@Override
	public Expression parse(final Stream<Token> input) throws ParserException {
		final var token = input.peek();

		if (keywordResolver.getVal(token).isPresent() || keywordResolver.getVar(token).isPresent()) {
			return variableParser.parse(input);
		} else if (keywordResolver.getIdentifier(token).isPresent()) {
			final PropertyAccess access = propertyAccessParser.parse(input);

			if (symbolResolver.getParanthesisOpen(input.peek()).isPresent()) {

			} else if (symbolResolver.getAssignment(input.peek()).isPresent()) {

			}

			return propertyAccessParser.parse(input);
		}

		throw new ParserException("Invalid Start of Expression:", token);
	}

}
