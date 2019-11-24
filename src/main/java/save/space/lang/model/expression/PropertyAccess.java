package save.space.lang.model.expression;

import java.util.List;

public class PropertyAccess implements Expression {

	private final List<String> chain;

	public PropertyAccess(final List<String> chain) {
		this.chain = chain;
	}

	public List<String> getChain() {
		return chain;
	}

}
