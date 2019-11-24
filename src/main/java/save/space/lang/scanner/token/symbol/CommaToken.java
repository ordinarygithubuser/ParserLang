package save.space.lang.scanner.token.symbol;

import save.space.lang.common.Location;

public class CommaToken extends SymbolToken {

	public CommaToken(final Location location) {
		super(location, SymbolTokens.COMMA);
	}

	@Override
	public <T> T accept(final SymbolTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
