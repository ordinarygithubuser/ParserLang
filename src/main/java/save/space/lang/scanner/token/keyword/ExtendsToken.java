package save.space.lang.scanner.token.keyword;

import save.space.lang.common.Location;

public class ExtendsToken extends KeywordToken {

	public ExtendsToken(final Location location) {
		super(location, "extends");
	}

	@Override
	public <T> T accept(final KeywordTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
