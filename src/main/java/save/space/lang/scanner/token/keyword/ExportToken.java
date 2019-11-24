package save.space.lang.scanner.token.keyword;

import save.space.lang.common.Location;

public class ExportToken extends KeywordToken {

	public ExportToken(final Location location) {
		super(location, "export");
	}

	@Override
	public <T> T accept(final KeywordTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
