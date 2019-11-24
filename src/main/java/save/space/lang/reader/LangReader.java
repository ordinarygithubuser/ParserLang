package save.space.lang.reader;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import org.springframework.stereotype.Service;

import save.space.lang.common.Stream;
import save.space.lang.common.Symbol;

@Service
public class LangReader {

	public Stream<Symbol> read(final String fileName) throws IOException {
		final var reader = new LineNumberReader(new FileReader(fileName));
		final var symbols = new Stream<Symbol>();
		String line = null;

		while ((line = reader.readLine()) != null) {
			final String[] chars = line.split("");

			for (int i = 0; i < chars.length; i++) {
				symbols.unshift(new Symbol(chars[i], reader.getLineNumber(), i + 1));
			}
		}

		reader.close();

		return symbols;
	}

}
