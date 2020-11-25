package parser;

public class ArquivoNaoEncontradoException extends Exception{
	public ArquivoNaoEncontradoException()
	{
		super("Erro ao abrir o arquivo. Arquivo não existente !");
	}
}
