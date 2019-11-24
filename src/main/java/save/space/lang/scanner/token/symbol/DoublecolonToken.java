package save.space.lang.scanner.token.symbol;

import save.space.lang.common.Location;

public class DoublecolonToken extends SymbolToken {

	public DoublecolonToken(final Location location) {
		super(location, SymbolTokens.DOUBLECOLON);
	}

	@Override
	public <T> T accept(final SymbolTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
