package save.space.lang.scanner.token.symbol;

import save.space.lang.common.Location;

public class DivisionToken extends SymbolToken {

	public DivisionToken(final Location location) {
		super(location, SymbolTokens.DIVISION);
	}

	@Override
	public <T> T accept(final SymbolTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
