package save.space.lang.model;

import java.util.List;

import save.space.lang.model.type.Type;
import save.space.lang.model.type.ref.ExternalTypeRerence;

public class Program {

	private final List<ExternalTypeRerence> imports;

	private final List<Type> exports;

	public Program(final List<ExternalTypeRerence> imports, final List<Type> exports) {
		this.imports = imports;
		this.exports = exports;
	}

	public List<ExternalTypeRerence> getImports() {
		return imports;
	}

	public List<Type> getExports() {
		return exports;
	}

}
