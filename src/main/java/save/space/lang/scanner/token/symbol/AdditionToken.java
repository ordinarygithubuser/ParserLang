package save.space.lang.scanner.token.symbol;

import save.space.lang.common.Location;

public class AdditionToken extends SymbolToken {

	public AdditionToken(final Location location) {
		super(location, SymbolTokens.ADDITION);
	}

	@Override
	public <T> T accept(final SymbolTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
