package save.space.lang.scanner.state;

import java.util.Optional;

import org.springframework.stereotype.Component;

import save.space.lang.common.Stream;
import save.space.lang.common.Symbol;
import save.space.lang.scanner.token.keyword.KeywordTokens;
import save.space.lang.scanner.token.symbol.SymbolTokens;

@Component
public class Matcher {

	private static final String DECIMAL = ".";

	private static final String NUMBER_REGEX = "\\d";

	public boolean isIdentifierStart(final String text) {
		return text.matches("[a-zA-Z]|$");
	}

	public boolean isIdentifier(final String text) {
		return text.matches("\\w|_|$");
	}

	public boolean isSymbol(final String value) {
		for (final String symbolType : SymbolTokens.VALUES) {
			if (symbolType.equals(value)) {
				return true;
			}
		}
		return false;
	}

	public boolean isKeyword(final String value) {
		for (final String keywordType : KeywordTokens.VALUES) {
			if (keywordType.equals(value)) {
				return true;
			}
		}
		return false;
	}

	public boolean isNumericStart(final String value) {
		return value.matches(NUMBER_REGEX);
	}

	public boolean isNumeric(final Stream<Symbol> symbols, final boolean decimalConsumed) {
		final Optional<Symbol> symbol = symbols.peek();

		if (symbol.isPresent()) {
			if (symbol.get().getValue().equals(DECIMAL)) {
				return !decimalConsumed;
			}

			return symbol.get().getValue().matches(NUMBER_REGEX);
		}

		return false;
	}

	public boolean isWhitespace(final String value) {
		return value.matches("[\\n\\r\\s]+");
	}

}
