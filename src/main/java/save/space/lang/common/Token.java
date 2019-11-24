package save.space.lang.common;

public abstract class Token {

	private final Location location;

	public Token(final Location location) {
		this.location = location;
	}

	public Location getLocation() {
		return location;
	}

	public abstract <T> T accept(TokenVisitor<T> visitor);

}
