package save.space.lang.scanner.token.keyword;

import save.space.lang.common.Location;

public class ReturnToken extends KeywordToken {

	public ReturnToken(final Location location) {
		super(location, "return");
	}

	@Override
	public <T> T accept(final KeywordTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
