package save.space.lang.parser.parsers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import save.space.lang.common.Parser;
import save.space.lang.common.Stream;
import save.space.lang.common.Token;
import save.space.lang.model.Program;
import save.space.lang.model.type.Type;
import save.space.lang.model.type.ref.ExternalTypeRerence;
import save.space.lang.parser.ParserException;

@Component
public class LangParser implements Parser<Program> {

	@Autowired
	private ImportsParser importsParser;

	@Autowired
	private ExportParser exportsParser;

	@Override
	public Program parse(final Stream<Token> tokens) throws ParserException {
		final List<ExternalTypeRerence> imports = importsParser.parse(tokens);
		final List<Type> exports = exportsParser.parse(tokens);

		return new Program(imports, exports);
	}

}
