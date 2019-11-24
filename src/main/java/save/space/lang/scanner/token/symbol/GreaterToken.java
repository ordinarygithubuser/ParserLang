package save.space.lang.scanner.token.symbol;

import save.space.lang.common.Location;

public class GreaterToken extends SymbolToken {

	public GreaterToken(final Location location) {
		super(location, SymbolTokens.GREATER);
	}

	@Override
	public <T> T accept(final SymbolTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
