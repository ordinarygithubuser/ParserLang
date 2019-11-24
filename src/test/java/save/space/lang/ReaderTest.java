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
import save.space.lang.reader.LangReader;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReaderTest {

	@Autowired
	private LangReader reader;

	private static final String PROGRAM = "D:/workspaces/sts/ParserLang/src/test/resources/bus.lang";

	@Test
	public void testSimpleProgram() throws IOException {
		final Stream<Symbol> symbols = reader.read(PROGRAM);

		assertEquals(267, symbols.size());

		Symbol symbol = symbols.pop().get();

		assertEquals("e", symbol.getValue());
		assertEquals(1, symbol.getLocation().getLine());
		assertEquals(1, symbol.getLocation().getColumn());

		assertEquals("x", symbols.pop().get().getValue());
		assertEquals("p", symbols.pop().get().getValue());
		assertEquals("o", symbols.pop().get().getValue());
		assertEquals("r", symbols.pop().get().getValue());
		assertEquals("t", symbols.pop().get().getValue());
		assertEquals(" ", symbols.pop().get().getValue());
		assertEquals("t", symbols.pop().get().getValue());
		assertEquals("y", symbols.pop().get().getValue());
		assertEquals("p", symbols.pop().get().getValue());
		assertEquals("e", symbols.pop().get().getValue());
		assertEquals(" ", symbols.pop().get().getValue());
		assertEquals("B", symbols.pop().get().getValue());
		assertEquals("u", symbols.pop().get().getValue());
		assertEquals("s", symbols.pop().get().getValue());
		assertEquals(" ", symbols.pop().get().getValue());
		assertEquals("{", symbols.pop().get().getValue());

		symbol = symbols.pop().get();

		assertEquals("", symbol.getValue());
		assertEquals(2, symbol.getLocation().getLine());
		assertEquals(1, symbol.getLocation().getColumn());

		assertEquals("\t", symbols.pop().get().getValue());

		symbol = symbols.pop().get();

		assertEquals("v", symbol.getValue());
		assertEquals(3, symbol.getLocation().getLine());
		assertEquals(2, symbol.getLocation().getColumn());

		assertEquals("a", symbols.pop().get().getValue());
		assertEquals("l", symbols.pop().get().getValue());
		assertEquals(" ", symbols.pop().get().getValue());

		for (int i = 0; i < 12; i++) {
			symbols.pop();
		}

		symbol = symbols.pop().get();

		assertEquals("=", symbol.getValue());
		assertEquals(3, symbol.getLocation().getLine());
		assertEquals(18, symbol.getLocation().getColumn());
	}

}
