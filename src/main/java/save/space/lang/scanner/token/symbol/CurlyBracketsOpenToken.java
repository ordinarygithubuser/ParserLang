package save.space.lang.scanner.token.symbol;

import save.space.lang.common.Location;

public class CurlyBracketsOpenToken extends SymbolToken {

	public CurlyBracketsOpenToken(final Location location) {
		super(location, SymbolTokens.CURLY_BRACKETS_OPEN);
	}

	@Override
	public <T> T accept(final SymbolTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
