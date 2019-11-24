package save.space.lang.parser.parsers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import save.space.lang.common.Parser;
import save.space.lang.common.Stream;
import save.space.lang.common.Token;
import save.space.lang.model.type.AttributeModifier;
import save.space.lang.parser.ParserException;
import save.space.lang.parser.check.KeywordTokenResolver;
import save.space.lang.scanner.token.keyword.PrivateToken;
import save.space.lang.scanner.token.keyword.ProtectedToken;
import save.space.lang.scanner.token.keyword.PublicToken;

@Component
public class AttributeModifierParser implements Parser<AttributeModifier> {

	@Autowired
	private KeywordTokenResolver keywordResolver;

	@Override
	public AttributeModifier parse(final Stream<Token> stream) throws ParserException {
		final Optional<Token> token = stream.pop();
		final Optional<PublicToken> publicToken = keywordResolver.getPublic(token);
		final Optional<PrivateToken> privateToken = keywordResolver.getPrivate(token);
		final Optional<ProtectedToken> protectedToken = keywordResolver.getProtected(token);

		if (publicToken.isPresent()) {
			return AttributeModifier.PUBLIC;
		} else if (privateToken.isPresent()) {
			return AttributeModifier.PRIVATE;
		} else if (protectedToken.isPresent()) {
			return AttributeModifier.PRIVATE;
		}

		throw new ParserException("Expected Attribute Modifier but got", token);
	}

}
