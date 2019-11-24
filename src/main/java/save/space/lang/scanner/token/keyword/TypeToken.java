package save.space.lang.scanner.token.keyword;

import save.space.lang.common.Location;

public class TypeToken extends KeywordToken {

	public TypeToken(final Location location) {
		super(location, "type");
	}

	@Override
	public <T> T accept(final KeywordTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
