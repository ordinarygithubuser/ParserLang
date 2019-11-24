package save.space.lang.scanner.token.symbol;

import save.space.lang.common.Location;

public class MultiplicationToken extends SymbolToken {

	public MultiplicationToken(final Location location) {
		super(location, SymbolTokens.MULTIPLICATION);
	}

	@Override
	public <T> T accept(final SymbolTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
