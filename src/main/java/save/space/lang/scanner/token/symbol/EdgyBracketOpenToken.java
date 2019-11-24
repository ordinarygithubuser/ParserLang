package save.space.lang.scanner.token.symbol;

import save.space.lang.common.Location;

public class EdgyBracketOpenToken extends SymbolToken {

	public EdgyBracketOpenToken(final Location location) {
		super(location, SymbolTokens.EDGY_BRACKETS_OPEN);
	}

	@Override
	public <T> T accept(final SymbolTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
