package save.space.lang.parser;

import java.util.Optional;

import save.space.lang.common.Token;

public class ParserException extends Exception {

	private static final long serialVersionUID = -4354143162068797361L;

	public <T extends Token> ParserException(final String message) {
		super(message);
	}

	public <T extends Token> ParserException(final String message, final T token) {
		super(message + " " + token);
	}

	public ParserException(final String message, final Optional<Token> token) {
		super(message + " " + (token.isPresent() ? token.get() : "null"));
	}

}
