package save.space.lang.scanner.token;

import save.space.lang.common.TokenVisitor;
import save.space.lang.scanner.token.keyword.KeywordToken;
import save.space.lang.scanner.token.symbol.SymbolToken;

public abstract class DefaultTokenVisitor<T> implements TokenVisitor<T> {

	private final T defaultValue;

	public DefaultTokenVisitor(final T defaultValue) {
		this.defaultValue = defaultValue;
	}

	@Override
	public T visit(final WhitespaceToken whitespaceToken) {
		return defaultValue;
	}

	@Override
	public T visit(final SymbolToken symbolToken) {
		return defaultValue;
	}

	@Override
	public T visit(final NumberToken numberToken) {
		return defaultValue;
	}

	@Override
	public T visit(final KeywordToken keywordToken) {
		return defaultValue;
	}

	@Override
	public T visit(final IdentifierToken identifierToken) {
		return defaultValue;
	}
}
