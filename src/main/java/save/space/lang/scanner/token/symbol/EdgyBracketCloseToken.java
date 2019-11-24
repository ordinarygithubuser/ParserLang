package save.space.lang.scanner.token.symbol;

import save.space.lang.common.Location;

public class EdgyBracketCloseToken extends SymbolToken {

	public EdgyBracketCloseToken(final Location location) {
		super(location, SymbolTokens.EDGY_BRACKETS_CLOSE);
	}

	@Override
	public <T> T accept(final SymbolTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
