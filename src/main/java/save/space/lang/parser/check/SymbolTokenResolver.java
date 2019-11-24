package save.space.lang.parser.check;

import java.util.Optional;

import org.springframework.stereotype.Component;

import save.space.lang.common.Token;
import save.space.lang.scanner.token.OptionalTokenVisitor;
import save.space.lang.scanner.token.symbol.AssignmentToken;
import save.space.lang.scanner.token.symbol.CommaToken;
import save.space.lang.scanner.token.symbol.CurlyBracketsCloseToken;
import save.space.lang.scanner.token.symbol.CurlyBracketsOpenToken;
import save.space.lang.scanner.token.symbol.DoublecolonToken;
import save.space.lang.scanner.token.symbol.EdgyBracketCloseToken;
import save.space.lang.scanner.token.symbol.EdgyBracketOpenToken;
import save.space.lang.scanner.token.symbol.OptionalSymbolToken;
import save.space.lang.scanner.token.symbol.ParanthesisCloseToken;
import save.space.lang.scanner.token.symbol.ParanthesisOpenToken;
import save.space.lang.scanner.token.symbol.PointToken;
import save.space.lang.scanner.token.symbol.SemicolonToken;
import save.space.lang.scanner.token.symbol.SymbolToken;

@Component
public class SymbolTokenResolver extends TokenResolver {

	public Optional<CurlyBracketsCloseToken> getContextClose(final Optional<Token> token) {
		return visitSymbol(token, new OptionalSymbolToken<CurlyBracketsCloseToken>() {
			@Override
			public Optional<CurlyBracketsCloseToken> visit(final CurlyBracketsCloseToken curlyBracketsCloseSymbol) {
				return Optional.of(curlyBracketsCloseSymbol);
			}
		});
	}

	public Optional<CurlyBracketsOpenToken> getContextOpen(final Optional<Token> token) {
		return visitSymbol(token, new OptionalSymbolToken<CurlyBracketsOpenToken>() {
			@Override
			public Optional<CurlyBracketsOpenToken> visit(final CurlyBracketsOpenToken curlyBracketsCloseSymbol) {
				return Optional.of(curlyBracketsCloseSymbol);
			}
		});
	}

	public Optional<SemicolonToken> getLineEnd(final Optional<Token> token) {
		return visitSymbol(token, new OptionalSymbolToken<SemicolonToken>() {
			@Override
			public Optional<SemicolonToken> visit(final SemicolonToken curlyBracketsCloseSymbol) {
				return Optional.of(curlyBracketsCloseSymbol);
			}
		});
	}

	public Optional<ParanthesisOpenToken> getParanthesisOpen(final Optional<Token> token) {
		return visitSymbol(token, new OptionalSymbolToken<ParanthesisOpenToken>() {
			@Override
			public Optional<ParanthesisOpenToken> visit(final ParanthesisOpenToken paranthesisOpenSymbol) {
				return Optional.of(paranthesisOpenSymbol);
			}
		});
	}

	public Optional<ParanthesisCloseToken> getParanthesisClose(final Optional<Token> token) {
		return visitSymbol(token, new OptionalSymbolToken<ParanthesisCloseToken>() {
			@Override
			public Optional<ParanthesisCloseToken> visit(final ParanthesisCloseToken paranthesisCloseSymbol) {
				return Optional.of(paranthesisCloseSymbol);
			}
		});
	}

	public Optional<CommaToken> getComma(final Optional<Token> token) {
		return visitSymbol(token, new OptionalSymbolToken<CommaToken>() {
			@Override
			public Optional<CommaToken> visit(final CommaToken commaSymbol) {
				return Optional.of(commaSymbol);
			}
		});
	}

	public Optional<DoublecolonToken> getDoublecolon(final Optional<Token> token) {
		return visitSymbol(token, new OptionalSymbolToken<DoublecolonToken>() {
			@Override
			public Optional<DoublecolonToken> visit(final DoublecolonToken doublecolonSymbol) {
				return Optional.of(doublecolonSymbol);
			}
		});
	}

	public Optional<AssignmentToken> getAssignment(final Optional<Token> token) {
		return visitSymbol(token, new OptionalSymbolToken<AssignmentToken>() {
			@Override
			public Optional<AssignmentToken> visit(final AssignmentToken doublecolonSymbol) {
				return Optional.of(doublecolonSymbol);
			}
		});
	}

	public Optional<EdgyBracketOpenToken> getEdgyBracketOpen(final Optional<Token> token) {
		return visitSymbol(token, new OptionalSymbolToken<EdgyBracketOpenToken>() {
			@Override
			public Optional<EdgyBracketOpenToken> visit(final EdgyBracketOpenToken edgyBracketCloseToken) {
				return Optional.of(edgyBracketCloseToken);
			}
		});
	}

	public Optional<EdgyBracketCloseToken> getEdgyBracketClose(final Optional<Token> token) {
		return visitSymbol(token, new OptionalSymbolToken<EdgyBracketCloseToken>() {
			@Override
			public Optional<EdgyBracketCloseToken> visit(final EdgyBracketCloseToken edgyBracketCloseToken) {
				return Optional.of(edgyBracketCloseToken);
			}
		});
	}

	public Optional<PointToken> getPoint(final Optional<Token> token) {
		return visitSymbol(token, new OptionalSymbolToken<PointToken>() {
			@Override
			public Optional<PointToken> visit(final PointToken pointToken) {
				return Optional.of(pointToken);
			}
		});
	}

	private <T extends SymbolToken> Optional<T> visitSymbol(final Optional<Token> token,
			final OptionalSymbolToken<T> visitor) {
		final Optional<SymbolToken> symbol = visitToken(token, new OptionalTokenVisitor<>() {
			public Optional<SymbolToken> visit(final SymbolToken symbolToken) {
				return Optional.of(symbolToken);
			}
		});

		if (symbol.isEmpty()) {
			return Optional.empty();
		}

		return symbol.get().accept(visitor);
	}

}
