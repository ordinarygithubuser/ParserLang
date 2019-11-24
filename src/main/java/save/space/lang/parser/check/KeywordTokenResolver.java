package save.space.lang.parser.check;

import java.util.Optional;

import org.springframework.stereotype.Component;

import save.space.lang.common.Token;
import save.space.lang.scanner.token.IdentifierToken;
import save.space.lang.scanner.token.OptionalTokenVisitor;
import save.space.lang.scanner.token.keyword.ExportToken;
import save.space.lang.scanner.token.keyword.ExtendsToken;
import save.space.lang.scanner.token.keyword.FromToken;
import save.space.lang.scanner.token.keyword.FunctionToken;
import save.space.lang.scanner.token.keyword.ImportToken;
import save.space.lang.scanner.token.keyword.KeywordToken;
import save.space.lang.scanner.token.keyword.OptionalKeywordVisitor;
import save.space.lang.scanner.token.keyword.PrivateToken;
import save.space.lang.scanner.token.keyword.ProtectedToken;
import save.space.lang.scanner.token.keyword.PublicToken;
import save.space.lang.scanner.token.keyword.TypeToken;
import save.space.lang.scanner.token.keyword.ValToken;
import save.space.lang.scanner.token.keyword.VarToken;

@Component
public class KeywordTokenResolver extends TokenResolver {

	public Optional<ExtendsToken> getExtends(final Optional<Token> token) {
		return visitKeyword(token, new OptionalKeywordVisitor<ExtendsToken>() {
			@Override
			public Optional<ExtendsToken> visit(final ExtendsToken extendsKeyword) {
				return Optional.of(extendsKeyword);
			}
		});
	}

	public Optional<ExportToken> getExports(final Optional<Token> token) {
		return visitKeyword(token, new OptionalKeywordVisitor<ExportToken>() {
			@Override
			public Optional<ExportToken> visit(final ExportToken exportKeyword) {
				return Optional.of(exportKeyword);
			}
		});
	}

	public Optional<FromToken> getFrom(final Optional<Token> token) {
		return visitKeyword(token, new OptionalKeywordVisitor<FromToken>() {
			@Override
			public Optional<FromToken> visit(final FromToken fromKeyword) {
				return Optional.of(fromKeyword);
			}
		});
	}

	public Optional<ImportToken> getImport(final Optional<Token> token) {
		return visitKeyword(token, new OptionalKeywordVisitor<ImportToken>() {
			@Override
			public Optional<ImportToken> visit(final ImportToken importKeyword) {
				return Optional.of(importKeyword);
			}
		});
	}

	public Optional<TypeToken> getType(final Optional<Token> token) {
		return visitKeyword(token, new OptionalKeywordVisitor<TypeToken>() {
			@Override
			public Optional<TypeToken> visit(final TypeToken typeKeyword) {
				return Optional.of(typeKeyword);
			}
		});
	}

	public Optional<VarToken> getVar(final Optional<Token> token) {
		return visitKeyword(token, new OptionalKeywordVisitor<VarToken>() {
			@Override
			public Optional<VarToken> visit(final VarToken varKeyword) {
				return Optional.of(varKeyword);
			}
		});
	}

	public Optional<ValToken> getVal(final Optional<Token> token) {
		return visitKeyword(token, new OptionalKeywordVisitor<ValToken>() {
			@Override
			public Optional<ValToken> visit(final ValToken valKeyword) {
				return Optional.of(valKeyword);
			}
		});
	}

	public Optional<PrivateToken> getPrivate(final Optional<Token> token) {
		return visitKeyword(token, new OptionalKeywordVisitor<PrivateToken>() {
			@Override
			public Optional<PrivateToken> visit(final PrivateToken privateKeyword) {
				return Optional.of(privateKeyword);
			}
		});
	}

	public Optional<ProtectedToken> getProtected(final Optional<Token> token) {
		return visitKeyword(token, new OptionalKeywordVisitor<ProtectedToken>() {
			@Override
			public Optional<ProtectedToken> visit(final ProtectedToken protectedKeyword) {
				return Optional.of(protectedKeyword);
			}
		});
	}

	public Optional<PublicToken> getPublic(final Optional<Token> token) {
		return visitKeyword(token, new OptionalKeywordVisitor<PublicToken>() {
			@Override
			public Optional<PublicToken> visit(final PublicToken publicKeyword) {
				return Optional.of(publicKeyword);
			}
		});
	}

	public Optional<FunctionToken> getFunction(final Optional<Token> token) {
		return visitKeyword(token, new OptionalKeywordVisitor<FunctionToken>() {
			@Override
			public Optional<FunctionToken> visit(final FunctionToken functionKeyword) {
				return Optional.of(functionKeyword);
			}
		});
	}

	public Optional<IdentifierToken> getIdentifier(final Optional<Token> token) {
		if (token.isEmpty()) {
			return Optional.empty();
		}

		return token.get().accept(new OptionalTokenVisitor<>() {
			@Override
			public Optional<IdentifierToken> visit(final IdentifierToken identifierToken) {
				return Optional.of(identifierToken);
			}
		});
	}

	private <T extends KeywordToken> Optional<T> visitKeyword(final Optional<Token> token,
			final OptionalKeywordVisitor<T> visitor) {
		final Optional<KeywordToken> keyword = visitToken(token, new OptionalTokenVisitor<>() {
			public Optional<KeywordToken> visit(final KeywordToken keywordToken) {
				return Optional.of(keywordToken);
			}
		});

		if (keyword.isEmpty()) {
			return Optional.empty();
		}

		return keyword.get().accept(visitor);
	}

}
