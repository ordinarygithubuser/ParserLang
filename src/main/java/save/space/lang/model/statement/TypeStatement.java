package save.space.lang.model.statement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import save.space.lang.model.type.ref.TypeReference;

public class TypeStatement {

	private final String name;

	private final List<TypeReference> generics;

	private final Optional<TypeReference> parent;

	public TypeStatement(final String name) {
		this.name = name;
		this.generics = new ArrayList<>();
		this.parent = Optional.empty();
	}

	public TypeStatement(final String name, final TypeReference parent) {
		this.name = name;
		this.generics = new ArrayList<>();
		this.parent = Optional.of(parent);
	}

	public TypeStatement(final String name, final List<TypeReference> generics) {
		this.name = name;
		this.generics = generics;
		this.parent = Optional.empty();
	}

	public String getName() {
		return name;
	}

	public List<TypeReference> getGenerics() {
		return generics;
	}

	public Optional<TypeReference> getParent() {
		return parent;
	}

}
