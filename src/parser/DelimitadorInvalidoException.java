package parser;

public class DelimitadorInvalidoException extends Exception{
	public DelimitadorInvalidoException()
	{
		super("Erro no delimitador do arquivo. Espera char mas recebeu string !");
	}
}
