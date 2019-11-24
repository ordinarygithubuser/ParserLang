package save.space.lang.scanner.token.symbol;

import save.space.lang.common.Location;

public class CurlyBracketsCloseToken extends SymbolToken {

	public CurlyBracketsCloseToken(final Location location) {
		super(location, SymbolTokens.CURLY_BRACKETS_CLOSE);
	}

	@Override
	public <T> T accept(final SymbolTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
