package save.space.lang.scanner.token.symbol;

import save.space.lang.common.Location;

public class OrToken extends SymbolToken {

	public OrToken(final Location location) {
		super(location, SymbolTokens.OR);
	}

	@Override
	public <T> T accept(final SymbolTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
