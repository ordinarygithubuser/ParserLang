package save.space.lang.parser.parsers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import save.space.lang.common.Parser;
import save.space.lang.common.Stream;
import save.space.lang.common.Token;
import save.space.lang.model.type.Method;
import save.space.lang.model.type.Type;
import save.space.lang.model.type.Variable;
import save.space.lang.model.type.ref.TypeReference;
import save.space.lang.parser.ParserException;
import save.space.lang.parser.check.KeywordTokenResolver;
import save.space.lang.parser.check.Require;
import save.space.lang.parser.check.SymbolTokenResolver;
import save.space.lang.scanner.token.keyword.ExtendsToken;

@Component
public class TypeParser implements Parser<Type> {

	@Autowired
	private Require require;

	@Autowired
	private SymbolTokenResolver symbolResolver;

	@Autowired
	private KeywordTokenResolver keywordResolver;

	@Autowired
	private IdentifierParser identifierParser;

	@Autowired
	private MethodParser methodParser;

	@Autowired
	private VariableParser variableParser;

	@Autowired
	private TypeReferenceParser typeReferenceParser;

	@Autowired
	private GenericTypeParser genericTypeParser;

	@Override
	public Type parse(final Stream<Token> input) throws ParserException {
		require.consumeType(input.pop());

		final String name = identifierParser.parse(input);
		final List<TypeReference> generics = genericTypeParser.parse(input);
		final Optional<TypeReference> superClass = parseSuperType(input);
		require.consumeContextOpen(input.pop());
		final List<Variable> fields = parseFields(input);
		final List<Method> methods = parseMethods(input);
		require.consumeContextClose(input.pop());

		return new Type(name, generics, superClass, fields, methods);
	}

	private Optional<TypeReference> parseSuperType(final Stream<Token> input) throws ParserException {
		final Optional<ExtendsToken> extendsKeyword = keywordResolver.getExtends(input.peek());

		if (extendsKeyword.isPresent()) {
			input.pop();

			return Optional.of(typeReferenceParser.parse(input));
		}

		return Optional.empty();
	}

	private List<Variable> parseFields(final Stream<Token> input) throws ParserException {
		final var variables = new ArrayList<Variable>();
		var token = input.peek();

		while (keywordResolver.getVal(token).isPresent() || keywordResolver.getVar(token).isPresent()) {
			variables.add(variableParser.parse(input));
			token = input.peek();
		}

		return variables;
	}

	private List<Method> parseMethods(final Stream<Token> input) throws ParserException {
		final List<Method> methods = new ArrayList<>();

		while (symbolResolver.getContextClose(input.peek()).isEmpty()) {
			methods.add(methodParser.parse(input));
		}

		return methods;
	}

}
