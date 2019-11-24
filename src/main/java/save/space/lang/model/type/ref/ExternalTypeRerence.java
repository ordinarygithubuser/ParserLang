package save.space.lang.model.type.ref;

public class ExternalTypeRerence implements TypeReference {

	private final String name;

	private final String modulePath;

	public ExternalTypeRerence(final String name, final String modulePath) {
		this.name = name;
		this.modulePath = modulePath;
	}

	public String getName() {
		return name;
	}

	public String getModulePath() {
		return modulePath;
	}

}
