package save.space.lang.scanner.token.symbol;

import save.space.lang.common.Location;

public class SemicolonToken extends SymbolToken {

	public SemicolonToken(final Location location) {
		super(location, SymbolTokens.SEMICOLON);
	}

	@Override
	public <T> T accept(final SymbolTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
