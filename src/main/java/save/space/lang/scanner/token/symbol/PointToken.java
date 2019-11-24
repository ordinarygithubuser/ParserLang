package save.space.lang.scanner.token.symbol;

import save.space.lang.common.Location;

public class PointToken extends SymbolToken {

	public PointToken(final Location location) {
		super(location, SymbolTokens.POINT);
	}

	@Override
	public <T> T accept(final SymbolTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
