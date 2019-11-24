package save.space.lang.common;

import save.space.lang.parser.ParserException;

public interface Parser<O> {

	O parse(Stream<Token> stream) throws ParserException;

}
