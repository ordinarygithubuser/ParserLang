package save.space.lang.scanner.token.symbol;

import save.space.lang.common.Location;

public class SmallerToken extends SymbolToken {

	public SmallerToken(final Location location) {
		super(location, SymbolTokens.SMALLER);
	}

	@Override
	public <T> T accept(final SymbolTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
