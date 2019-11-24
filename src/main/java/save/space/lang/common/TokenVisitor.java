package save.space.lang.common;

import save.space.lang.scanner.token.IdentifierToken;
import save.space.lang.scanner.token.NumberToken;
import save.space.lang.scanner.token.WhitespaceToken;
import save.space.lang.scanner.token.keyword.KeywordToken;
import save.space.lang.scanner.token.symbol.SymbolToken;

public interface TokenVisitor<T> {

	T visit(WhitespaceToken whitespaceToken);

	T visit(SymbolToken symbolToken);

	T visit(NumberToken numberToken);

	T visit(KeywordToken keywordToken);

	T visit(IdentifierToken identifierToken);

}
