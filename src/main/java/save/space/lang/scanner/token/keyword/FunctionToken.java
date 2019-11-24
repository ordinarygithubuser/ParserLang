package save.space.lang.scanner.token.keyword;

import save.space.lang.common.Location;

public class FunctionToken extends KeywordToken {

	public FunctionToken(final Location location) {
		super(location, "function");
	}

	@Override
	public <T> T accept(final KeywordTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
