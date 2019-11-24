package save.space.lang.scanner.token.keyword;

import save.space.lang.common.Location;

public class FromToken extends KeywordToken {

	public FromToken(final Location location) {
		super(location, "from");
	}

	@Override
	public <T> T accept(final KeywordTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
