package save.space.lang.scanner.state;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import save.space.lang.common.Location;
import save.space.lang.common.Stream;
import save.space.lang.common.Symbol;
import save.space.lang.common.Token;
import save.space.lang.machine.MachineException;
import save.space.lang.machine.State;
import save.space.lang.scanner.token.IdentifierToken;
import save.space.lang.scanner.token.keyword.ExportToken;
import save.space.lang.scanner.token.keyword.ExtendsToken;
import save.space.lang.scanner.token.keyword.FromToken;
import save.space.lang.scanner.token.keyword.FunctionToken;
import save.space.lang.scanner.token.keyword.ImportToken;
import save.space.lang.scanner.token.keyword.KeywordToken;
import save.space.lang.scanner.token.keyword.KeywordTokens;
import save.space.lang.scanner.token.keyword.NewToken;
import save.space.lang.scanner.token.keyword.PrivateToken;
import save.space.lang.scanner.token.keyword.ProtectedToken;
import save.space.lang.scanner.token.keyword.PublicToken;
import save.space.lang.scanner.token.keyword.ReturnToken;
import save.space.lang.scanner.token.keyword.TypeToken;
import save.space.lang.scanner.token.keyword.ValToken;
import save.space.lang.scanner.token.keyword.VarToken;

@Component
public class KeywordIdentifierState extends State<Symbol, Token> {

	@Autowired
	private Matcher matcher;

	@Override
	public Token consume(final Symbol currentSymbol, final Stream<Symbol> rest) throws MachineException {
		final Location location = currentSymbol.getLocation();
		final StringBuilder builder = new StringBuilder(currentSymbol.getValue());
		final Optional<Symbol> next = rest.peek();

		while (next.isPresent() && matcher.isIdentifier(next.get().getValue())) {
			builder.append(rest.pop().get().getValue());
			final var value = builder.toString();

			if (matcher.isKeyword(value)) {
				return createKeyword(value, location);
			}
		}

		return new IdentifierToken(location, builder.toString());
	}

	@Override
	public boolean matches(final Optional<Symbol> input) {
		return input.isPresent() && matcher.isIdentifierStart(input.get().getValue());
	}

	private KeywordToken createKeyword(final String name, final Location location) throws MachineException {
		switch (name) {
		case KeywordTokens.EXPORT:
			return new ExportToken(location);
		case KeywordTokens.EXTENDS:
			return new ExtendsToken(location);
		case KeywordTokens.FROM:
			return new FromToken(location);
		case KeywordTokens.FUNCTION:
			return new FunctionToken(location);
		case KeywordTokens.IMPORT:
			return new ImportToken(location);
		case KeywordTokens.NEW:
			return new NewToken(location);
		case KeywordTokens.PRIVATE:
			return new PrivateToken(location);
		case KeywordTokens.PROTECTED:
			return new ProtectedToken(location);
		case KeywordTokens.PUBLIC:
			return new PublicToken(location);
		case KeywordTokens.RETURN:
			return new ReturnToken(location);
		case KeywordTokens.TYPE:
			return new TypeToken(location);
		case KeywordTokens.VAL:
			return new ValToken(location);
		case KeywordTokens.VAR:
			return new VarToken(location);
		default:
			throw new MachineException("Invalid Keyword", this, name);
		}
	}

}
