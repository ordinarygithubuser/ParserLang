package save.space.lang.scanner.token.keyword;

import save.space.lang.common.Location;

public class PrivateToken extends KeywordToken {

	public PrivateToken(final Location location) {
		super(location, KeywordTokens.PRIVATE);
	}

	@Override
	public <T> T accept(final KeywordTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
