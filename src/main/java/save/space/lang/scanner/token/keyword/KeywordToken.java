package save.space.lang.scanner.token.keyword;

import save.space.lang.common.Location;
import save.space.lang.common.Token;
import save.space.lang.common.TokenVisitor;

public abstract class KeywordToken extends Token {

	private final String name;

	public KeywordToken(final Location location, final String name) {
		super(location);
		this.name = name;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "(" + getName() + ", " + getLocation() + ")";
	}

	@Override
	public <T> T accept(final TokenVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public abstract <T> T accept(KeywordTokenVisitor<T> visitor);

	public String getName() {
		return name;
	}
}
