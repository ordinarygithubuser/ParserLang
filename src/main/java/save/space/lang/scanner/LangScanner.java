package save.space.lang.scanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import save.space.lang.common.Stream;
import save.space.lang.common.Symbol;
import save.space.lang.common.Token;
import save.space.lang.machine.Machine;
import save.space.lang.machine.MachineException;
import save.space.lang.machine.State;
import save.space.lang.scanner.state.KeywordIdentifierState;
import save.space.lang.scanner.state.Matcher;
import save.space.lang.scanner.state.NumberState;
import save.space.lang.scanner.state.SymbolState;
import save.space.lang.scanner.state.WhitespaceState;
import save.space.lang.scanner.token.DefaultTokenVisitor;
import save.space.lang.scanner.token.WhitespaceToken;

@Service
public class LangScanner extends Machine<Symbol, Token> {

	@Autowired
	private Matcher matcher;

	@Autowired
	private KeywordIdentifierState keywordIdentifierState;

	@Autowired
	private NumberState numberState;

	@Autowired
	private WhitespaceState whitespaceState;

	@Autowired
	private SymbolState symbolState;

	@PostConstruct
	public void setup() {
		addTransition(keywordIdentifierState, whitespaceState, symbol -> matcher.isWhitespace(symbol.getValue()));
		addTransition(keywordIdentifierState, symbolState, symbol -> matcher.isSymbol(symbol.getValue()));

		addTransition(whitespaceState, keywordIdentifierState, symbol -> matcher.isIdentifierStart(symbol.getValue()));
		addTransition(whitespaceState, symbolState, symbol -> matcher.isSymbol(symbol.getValue()));
		addTransition(whitespaceState, numberState, symbol -> matcher.isNumericStart(symbol.getValue()));
		addTransition(whitespaceState, whitespaceState, symbol -> matcher.isWhitespace(symbol.getValue()));

		addTransition(symbolState, numberState, symbol -> matcher.isNumericStart(symbol.getValue()));
		addTransition(symbolState, keywordIdentifierState, symbol -> matcher.isIdentifierStart(symbol.getValue()));
		addTransition(symbolState, whitespaceState, symbol -> matcher.isWhitespace(symbol.getValue()));
		addTransition(symbolState, symbolState, symbol -> matcher.isSymbol(symbol.getValue()));

		addTransition(numberState, symbolState, symbol -> matcher.isSymbol(symbol.getValue()));
		addTransition(numberState, whitespaceState, symbol -> matcher.isWhitespace(symbol.getValue()));
	}

	public Stream<Token> scan(final Stream<Symbol> symbols, final boolean denoise) throws MachineException {
		final Stream<Token> result = process(symbols);

		return denoise ? removeNoise(result) : result;
	}

	private Stream<Token> removeNoise(final Stream<Token> result) {
		return result.filter(token -> token.accept(new DefaultTokenVisitor<>(true) {
			@Override
			public Boolean visit(final WhitespaceToken whitespaceToken) {
				return false;
			}
		}));
	}

	@Override
	protected State<Symbol, Token> getStartState() {
		return whitespaceState;
	}

	@Override
	protected boolean isLineEnd(final Symbol input) {
		return input.getValue().equals(";");
	}

}
