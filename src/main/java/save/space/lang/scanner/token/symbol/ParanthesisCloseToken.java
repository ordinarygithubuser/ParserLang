package save.space.lang.scanner.token.symbol;

import save.space.lang.common.Location;

public class ParanthesisCloseToken extends SymbolToken {

	public ParanthesisCloseToken(final Location location) {
		super(location, SymbolTokens.PARANTHESIS_CLOSE);
	}

	@Override
	public <T> T accept(final SymbolTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
