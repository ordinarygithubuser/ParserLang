package save.space.lang;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import save.space.lang.machine.MachineException;
import save.space.lang.parser.ParserException;
import save.space.lang.parser.parsers.LangParser;
import save.space.lang.reader.LangReader;
import save.space.lang.scanner.LangScanner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ParserTest {

	private static final String PROGRAM = "D:/workspaces/sts/ParserLang/src/test/resources/bus.lang";
	@Autowired
	private LangScanner scanner;

	@Autowired
	private LangReader reader;

	@Autowired
	private LangParser parser;

	@Test
	public void testSimpleProgram() throws IOException, MachineException, ParserException {
		final var symbols = reader.read(PROGRAM);
		final var tokens = scanner.scan(symbols, true);
		final var result = parser.parse(tokens);

		System.out.println(result);

	}
}
