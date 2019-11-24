package save.space.lang.model.type.base;

import save.space.lang.model.type.Any;

public class StringType implements Any {

	private String value;

	public StringType(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(final String value) {
		this.value = value;
	}

}
