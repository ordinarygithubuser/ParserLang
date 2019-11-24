package save.space.lang.scanner.token.symbol;

import save.space.lang.common.Location;

public class LambdaToken extends SymbolToken {

	public LambdaToken(final Location location) {
		super(location, SymbolTokens.LAMBDA);
	}

	@Override
	public <T> T accept(final SymbolTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
