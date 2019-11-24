package save.space.lang.scanner.token.keyword;

import save.space.lang.common.Location;

public class VarToken extends KeywordToken {

	public VarToken(final Location location) {
		super(location, KeywordTokens.VAR);
	}

	@Override
	public <T> T accept(final KeywordTokenVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
