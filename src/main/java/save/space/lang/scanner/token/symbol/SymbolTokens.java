package save.space.lang.scanner.token.symbol;

import java.util.Arrays;
import java.util.List;

public class SymbolTokens {

	public static final String ADDITION = "+";

	public static final String SUBTRACTION = "-";

	public static final String DIVISION = "/";

	public static final String MULTIPLICATION = "*";

	public static final String AND = "&&";

	public static final String OR = "||";

	public static final String ASSIGNMENT = "=";

	public static final String COMMA = ",";

	public static final String CURLY_BRACKETS_OPEN = "{";

	public static final String CURLY_BRACKETS_CLOSE = "}";

	public static final String DOUBLECOLON = ":";

	public static final String SEMICOLON = ";";

	public static final String POINT = ".";

	public static final String EDGY_BRACKETS_OPEN = "[";

	public static final String EDGY_BRACKETS_CLOSE = "]";

	public static final String EQUALITY = "==";

	public static final String GREATER = ">";

	public static final String SMALLER = "<";

	public static final String LAMBDA = "->";

	public static final String PARANTHESIS_OPEN = "(";

	public static final String PARANTHESIS_CLOSE = ")";

	public static final String QUOTE = "\"";

	public static final List<String> VALUES = Arrays.asList(ADDITION, SUBTRACTION, DIVISION, MULTIPLICATION, AND, OR,
			ASSIGNMENT, COMMA, CURLY_BRACKETS_CLOSE, CURLY_BRACKETS_OPEN, DOUBLECOLON, SEMICOLON, POINT,
			EDGY_BRACKETS_CLOSE, EDGY_BRACKETS_OPEN, EQUALITY, GREATER, SMALLER, LAMBDA, PARANTHESIS_OPEN,
			PARANTHESIS_CLOSE, QUOTE);

}
