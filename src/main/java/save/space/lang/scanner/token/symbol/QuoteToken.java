package save.space.lang.scanner.token.symbol;

import save.space.lang.common.Location;

public class QuoteToken extends SymbolToken {

	public QuoteToken(final Location location) {
		super(location, SymbolTokens.QUOTE);
	}

	@Override
	public <T> T accept(final SymbolTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
