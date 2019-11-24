package save.space.lang.model.type.ref;

import java.util.List;

public class UnresolvedTypeReference implements TypeReference {

	private final String name;

	private final List<TypeReference> generics;

	public UnresolvedTypeReference(final String name, final List<TypeReference> generics) {
		this.name = name;
		this.generics = generics;
	}

	public String getName() {
		return name;
	}

	public List<TypeReference> getGenerics() {
		return generics;
	}

}
