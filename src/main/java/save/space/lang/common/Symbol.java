package save.space.lang.common;

public class Symbol {

	private final String value;

	private final Location location;

	public Symbol(final String chars, final int line, final int column) {
		this.value = chars;
		this.location = new Location(line, column);
	}

	public String getValue() {
		return value;
	}

	public Location getLocation() {
		return location;
	}

	@Override
	public String toString() {
		return "Symbol('" + value + "', " + location + ")";
	}

}
