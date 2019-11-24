package save.space.lang.scanner.token.keyword;

import save.space.lang.common.Location;

public class ProtectedToken extends KeywordToken {

	public ProtectedToken(final Location location) {
		super(location, KeywordTokens.PROTECTED);
	}

	@Override
	public <T> T accept(final KeywordTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
