package save.space.lang.model.type;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import save.space.lang.model.type.ref.TypeReference;

public class Type {

	private final String name;

	private final List<TypeReference> generics;

	private final Optional<TypeReference> superClass;

	private final List<Variable> fields;

	private final List<Method> methods;

	public Type(final String name, final List<TypeReference> generics, final Optional<TypeReference> superClass,
			final List<Variable> fields, final List<Method> methods) {
		this.name = name;
		this.generics = generics;
		this.superClass = superClass;
		this.fields = new ArrayList<>();
		this.methods = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public List<TypeReference> getGenerics() {
		return generics;
	}

	public Optional<TypeReference> getSuperClass() {
		return superClass;
	}

	public List<Variable> getFields() {
		return fields;
	}

	public List<Method> getMethods() {
		return methods;
	}

}
