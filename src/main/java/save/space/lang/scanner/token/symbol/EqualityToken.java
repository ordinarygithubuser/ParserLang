package save.space.lang.scanner.token.symbol;

import save.space.lang.common.Location;

public class EqualityToken extends SymbolToken {

	public EqualityToken(final Location location) {
		super(location, SymbolTokens.EQUALITY);
	}

	@Override
	public <T> T accept(final SymbolTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
