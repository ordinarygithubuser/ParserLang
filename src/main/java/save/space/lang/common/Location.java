package save.space.lang.common;

public class Location {

	private final int line;

	private final int column;

	public Location(final int line, final int column) {
		this.line = line;
		this.column = column;
	}

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}

	@Override
	public String toString() {
		return "Location (" + line + "/" + column + ")";
	}

}
