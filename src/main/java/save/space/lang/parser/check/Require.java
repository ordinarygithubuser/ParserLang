package save.space.lang.parser.check;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import save.space.lang.common.Token;
import save.space.lang.parser.ParserException;
import save.space.lang.scanner.token.keyword.KeywordTokens;
import save.space.lang.scanner.token.symbol.SymbolTokens;

@Component
public class Require {

	@Autowired
	private SymbolTokenResolver symbolResolver;

	@Autowired
	private KeywordTokenResolver keywordResolver;

	public void consumeFrom(final Optional<Token> token) throws ParserException {
		if (keywordResolver.getFrom(token).isEmpty()) {
			throw createException(KeywordTokens.FROM, token);
		}
	}

	public void consumeType(final Optional<Token> token) throws ParserException {
		if (keywordResolver.getType(token).isEmpty()) {
			throw createException(KeywordTokens.TYPE, token);
		}
	}

	public void consumeExports(final Optional<Token> token) throws ParserException {
		if (keywordResolver.getExports(token).isEmpty()) {
			throw createException(KeywordTokens.EXPORT, token);
		}
	}

	public void consumeExtends(final Optional<Token> token) throws ParserException {
		if (keywordResolver.getExtends(token).isEmpty()) {
			throw createException(KeywordTokens.EXTENDS, token);
		}
	}

	public void consumeFunction(final Optional<Token> token) throws ParserException {
		if (keywordResolver.getFunction(token).isEmpty()) {
			throw createException(KeywordTokens.FUNCTION, token);
		}
	}

	public void consumeSemicolon(final Optional<Token> token) throws ParserException {
		if (symbolResolver.getLineEnd(token).isEmpty()) {
			throw createException(SymbolTokens.SEMICOLON, token);
		}
	}

	public void consumeComma(final Optional<Token> token) throws ParserException {
		if (symbolResolver.getComma(token).isEmpty()) {
			throw createException(SymbolTokens.COMMA, token);
		}
	}

	public void consumeDoublecolon(final Optional<Token> token) throws ParserException {
		if (symbolResolver.getDoublecolon(token).isEmpty()) {
			throw createException(SymbolTokens.DOUBLECOLON, token);
		}
	}

	public void consumeParanthesisOpen(final Optional<Token> token) throws ParserException {
		if (symbolResolver.getParanthesisOpen(token).isEmpty()) {
			throw createException(SymbolTokens.PARANTHESIS_OPEN, token);
		}
	}

	public void consumeParanthesisClose(final Optional<Token> token) throws ParserException {
		if (symbolResolver.getParanthesisClose(token).isEmpty()) {
			throw createException(SymbolTokens.PARANTHESIS_CLOSE, token);
		}
	}

	public void consumeContextOpen(final Optional<Token> token) throws ParserException {
		if (symbolResolver.getContextOpen(token).isEmpty()) {
			throw createException(SymbolTokens.CURLY_BRACKETS_OPEN, token);
		}
	}

	public void consumeContextClose(final Optional<Token> token) throws ParserException {
		if (symbolResolver.getContextClose(token).isEmpty()) {
			throw createException(SymbolTokens.CURLY_BRACKETS_CLOSE, token);
		}
	}

	public void consumeEdgyBracketClose(final Optional<Token> token) throws ParserException {
		if (symbolResolver.getEdgyBracketClose(token).isEmpty()) {
			throw createException(SymbolTokens.EDGY_BRACKETS_CLOSE, token);
		}
	}

	public void consumeAssignment(final Optional<Token> token) throws ParserException {
		if (symbolResolver.getAssignment(token).isEmpty()) {
			throw createException(SymbolTokens.ASSIGNMENT, token);
		}
	}

	private ParserException createException(final String type, final Optional<Token> token) {
		return new ParserException("Expected '" + type + "' but got", token);
	}

}
