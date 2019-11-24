package save.space.lang.model.type.base;

import save.space.lang.model.type.Any;

public class NullType implements Any {

	private static NullType instance;

	private NullType() {

	}

	public static NullType getInstance() {
		if (instance == null) {
			instance = new NullType();
		}
		return instance;
	}

}
