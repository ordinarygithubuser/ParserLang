package save.space.lang.scanner.token.keyword;

import java.util.Optional;

public abstract class OptionalKeywordVisitor<T> implements KeywordTokenVisitor<Optional<T>> {

	private final Optional<T> defaultValue;

	public OptionalKeywordVisitor() {
		this.defaultValue = Optional.empty();
	}

	public OptionalKeywordVisitor(final T value) {
		this.defaultValue = Optional.of(value);
	}

	@Override
	public Optional<T> visit(final ExportToken exportKeyword) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final ImportToken importKeyword) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final FunctionToken functionKeyword) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final FromToken fromKeyword) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final ExtendsToken extendsKeyword) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final ReturnToken returnKeyword) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final TypeToken typeKeyword) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final PrivateToken privateKeyword) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final ProtectedToken protectedKeyword) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final PublicToken publicKeyword) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final ValToken valKeyword) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final VarToken varKeyword) {
		return defaultValue;
	}

	@Override
	public Optional<T> visit(final NewToken newKeyword) {
		return defaultValue;
	}

}
