package save.space.lang;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import save.space.lang.common.Stream;
import save.space.lang.common.Symbol;
import save.space.lang.common.Token;
import save.space.lang.machine.MachineException;
import save.space.lang.reader.LangReader;
import save.space.lang.scanner.LangScanner;
import save.space.lang.scanner.token.IdentifierToken;
import save.space.lang.scanner.token.keyword.ExportToken;
import save.space.lang.scanner.token.keyword.TypeToken;
import save.space.lang.scanner.token.keyword.ValToken;
import save.space.lang.scanner.token.symbol.CurlyBracketsOpenToken;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ScannerTest {

	private static final String PROGRAM = "D:/workspaces/sts/ParserLang/src/test/resources/bus.lang";

	@Autowired
	private LangScanner scanner;

	@Autowired
	private LangReader reader;

	@Test
	public void testSimpleProgram() throws IOException, MachineException {
		final Stream<Symbol> symbols = reader.read(PROGRAM);
		final Stream<Token> result = scanner.scan(symbols, true);

		assertEquals(70, result.size());

		assertEquals(ExportToken.class, result.pop().get().getClass());
		assertEquals(TypeToken.class, result.pop().get().getClass());

		IdentifierToken token = (IdentifierToken) result.pop().get();

		assertEquals("Bus", token.getIdentifier());

		assertEquals(CurlyBracketsOpenToken.class, result.pop().get().getClass());
		assertEquals(ValToken.class, result.pop().get().getClass());

		token = (IdentifierToken) result.pop().get();

		assertEquals("connections", token.getIdentifier());
	}

}
