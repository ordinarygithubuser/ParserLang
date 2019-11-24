package save.space.lang.scanner.token.symbol;

import save.space.lang.common.Location;

public class AndToken extends SymbolToken {

	public AndToken(final Location location) {
		super(location, SymbolTokens.AND);
	}

	@Override
	public <T> T accept(final SymbolTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
