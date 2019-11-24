package save.space.lang.scanner.token;

import java.util.Optional;

import save.space.lang.common.TokenVisitor;
import save.space.lang.scanner.token.keyword.KeywordToken;
import save.space.lang.scanner.token.symbol.SymbolToken;

public abstract class OptionalTokenVisitor<T> implements TokenVisitor<Optional<T>> {

	@Override
	public Optional<T> visit(final WhitespaceToken whitespaceToken) {
		return Optional.empty();
	}

	@Override
	public Optional<T> visit(final SymbolToken symbolToken) {
		return Optional.empty();
	}

	@Override
	public Optional<T> visit(final NumberToken numberToken) {
		return Optional.empty();
	}

	@Override
	public Optional<T> visit(final KeywordToken keywordToken) {
		return Optional.empty();
	}

	@Override
	public Optional<T> visit(final IdentifierToken identifierToken) {
		return Optional.empty();
	}

}
