package save.space.lang.scanner.token.keyword;

public interface KeywordTokenVisitor<T> {

	T visit(ExportToken exportKeyword);

	T visit(ImportToken importKeyword);

	T visit(FunctionToken functionKeyword);

	T visit(FromToken fromKeyword);

	T visit(ExtendsToken extendsKeyword);

	T visit(ReturnToken returnKeyword);

	T visit(TypeToken typeKeyword);

	T visit(ValToken valKeyword);

	T visit(VarToken varKeyword);

	T visit(NewToken newKeyword);

	T visit(PublicToken publicKeyword);

	T visit(ProtectedToken protectedKeyword);

	T visit(PrivateToken privateKeyword);

}
