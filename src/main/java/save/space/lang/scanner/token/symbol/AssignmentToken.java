package save.space.lang.scanner.token.symbol;

import save.space.lang.common.Location;

public class AssignmentToken extends SymbolToken {

	public AssignmentToken(final Location location) {
		super(location, SymbolTokens.ASSIGNMENT);
	}

	@Override
	public <T> T accept(final SymbolTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
