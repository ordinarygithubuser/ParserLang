package save.space.lang.model.type.base;

import save.space.lang.model.type.Any;

public class BooleanType implements Any {

	private final boolean value;

	public BooleanType(final boolean value) {
		this.value = value;
	}

	public boolean isValue() {
		return value;
	}

}
