package save.space.lang.scanner.token;

import save.space.lang.common.Location;
import save.space.lang.common.Token;
import save.space.lang.common.TokenVisitor;

public class IdentifierToken extends Token {

	private final String identifier;

	public IdentifierToken(final Location location, final String value) {
		super(location);
		this.identifier = value;
	}

	public String getIdentifier() {
		return identifier;
	}

	@Override
	public String toString() {
		return "IdentifierToken (" + identifier + ",  " + getLocation() + ")";
	}

	@Override
	public <T> T accept(final TokenVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
