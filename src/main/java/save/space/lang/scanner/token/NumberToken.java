package save.space.lang.scanner.token;

import save.space.lang.common.Location;
import save.space.lang.common.Token;
import save.space.lang.common.TokenVisitor;

public class NumberToken extends Token {

	private final Double number;

	public NumberToken(final Location location, final Double number) {
		super(location);
		this.number = number;
	}

	public Double getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "NumberToken (" + number + ",  " + getLocation() + ")";
	}

	@Override
	public <T> T accept(final TokenVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
