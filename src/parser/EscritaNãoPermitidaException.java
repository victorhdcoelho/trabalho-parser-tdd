package parser;

public class EscritaNãoPermitidaException extends Exception{
	public EscritaNãoPermitidaException()
	{
		super("Erro ao savar arquivo. Escrita não permitida !");
	}
}
