package save.space.lang.model.type;

import save.space.lang.model.type.ref.TypeReference;

public class Parameter {

	private final String name;

	private final TypeReference type;

	public Parameter(final String name, final TypeReference type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public TypeReference getType() {
		return type;
	}

}
