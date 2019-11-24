package save.space.lang.scanner.token.keyword;

import save.space.lang.common.Location;

public class ValToken extends KeywordToken {

	public ValToken(final Location location) {
		super(location, "val");
	}

	@Override
	public <T> T accept(final KeywordTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
