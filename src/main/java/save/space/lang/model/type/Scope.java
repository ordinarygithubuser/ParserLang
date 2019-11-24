package save.space.lang.model.type;

import java.util.ArrayList;
import java.util.List;

public class Scope {

	private final List<Variable> members;

	public Scope() {
		this.members = new ArrayList<>();
	}

	public Scope(final ArrayList<Variable> members) {
		this.members = members;
	}

	public List<Variable> getMembers() {
		return members;
	}

}
