package save.space.lang.scanner.token.symbol;

import save.space.lang.common.Location;
import save.space.lang.common.Token;
import save.space.lang.common.TokenVisitor;

public abstract class SymbolToken extends Token {

	private final String value;

	public SymbolToken(final Location location, final String value) {
		super(location);
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "(" + getLocation() + ")";
	}

	@Override
	public <T> T accept(final TokenVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public abstract <T> T accept(SymbolTokenVisitor<T> visitor);
}
