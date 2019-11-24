package save.space.lang.scanner.token.keyword;

import save.space.lang.common.Location;

public class NewToken extends KeywordToken {

	public NewToken(final Location location) {
		super(location, KeywordTokens.NEW);
	}

	@Override
	public <T> T accept(final KeywordTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
