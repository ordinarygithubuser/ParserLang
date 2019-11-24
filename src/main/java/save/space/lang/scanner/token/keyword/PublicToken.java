package save.space.lang.scanner.token.keyword;

import save.space.lang.common.Location;

public class PublicToken extends KeywordToken {

	public PublicToken(final Location location) {
		super(location, KeywordTokens.PUBLIC);
	}

	@Override
	public <T> T accept(final KeywordTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
