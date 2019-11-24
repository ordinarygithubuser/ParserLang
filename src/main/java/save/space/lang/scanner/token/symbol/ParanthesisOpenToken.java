package save.space.lang.scanner.token.symbol;

import save.space.lang.common.Location;

public class ParanthesisOpenToken extends SymbolToken {

	public ParanthesisOpenToken(final Location location) {
		super(location, SymbolTokens.PARANTHESIS_OPEN);
	}

	@Override
	public <T> T accept(final SymbolTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
