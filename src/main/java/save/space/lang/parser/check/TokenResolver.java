package save.space.lang.parser.check;

import java.util.Optional;

import save.space.lang.common.Token;
import save.space.lang.scanner.token.OptionalTokenVisitor;

public abstract class TokenResolver {

	protected <T extends Token> Optional<T> visitToken(final Optional<Token> token,
			final OptionalTokenVisitor<T> visitor) {
		if (!token.isPresent()) {
			return Optional.empty();
		}

		return token.get().accept(visitor);
	}

}
