package save.space.lang.scanner.token;

import save.space.lang.common.Location;
import save.space.lang.common.Token;
import save.space.lang.common.TokenVisitor;

public class WhitespaceToken extends Token {

	private final String whitespace;

	public WhitespaceToken(final Location location, final String whitespace) {
		super(location);
		this.whitespace = whitespace;
	}

	public String getWhitespace() {
		return whitespace;
	}

	@Override
	public String toString() {
		return "WhitespaceToken ('" + whitespace + "',  " + getLocation() + ")";
	}

	@Override
	public <T> T accept(final TokenVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
