package save.space.lang.scanner.token.keyword;

import save.space.lang.common.Location;

public class ImportToken extends KeywordToken {

	public ImportToken(final Location location) {
		super(location, "import");
	}

	@Override
	public <T> T accept(final KeywordTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
