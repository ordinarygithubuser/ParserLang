package save.space.lang.scanner.token.symbol;

import save.space.lang.common.Location;

public class SubtractionToken extends SymbolToken {

	public SubtractionToken(final Location location) {
		super(location, SymbolTokens.SUBTRACTION);
	}

	@Override
	public <T> T accept(final SymbolTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
