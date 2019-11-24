package save.space.lang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import save.space.lang.parser.parsers.LangParser;
import save.space.lang.reader.LangReader;
import save.space.lang.scanner.LangScanner;

@SpringBootApplication
public class App implements CommandLineRunner {

	@Autowired
	private LangReader reader;

	@Autowired
	private LangScanner scanner;

	@Autowired
	private LangParser parser;

	public static void main(final String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(final String... args) throws Exception {
		if (args.length > 0) {
			final String sourceFilePath = args[0];

			final var symbols = reader.read(sourceFilePath);
			final var tokens = scanner.scan(symbols, true);
			final var model = parser.parse(tokens);

			System.out.println(model);
		}
	}

}
