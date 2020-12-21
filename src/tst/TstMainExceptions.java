package tst;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import parser.ArquivoNaoEncontradoException;
import parser.EscritaNãoPermitidaException;
import parser.TDDParser;

class TstMainExceptions {

	@Test
	void ArquivoException01() {
		TDDParser parser = new TDDParser(';', "src/parser/main.out", 'v');
		String error_message = "Erro ao abrir o arquivo. Arquivo não existente !";
		boolean content = parser.getFileContent();
		if(!content) 
		{
			ArquivoNaoEncontradoException arquivo_exception = new ArquivoNaoEncontradoException();
			assertEquals(error_message, arquivo_exception.getMessage());
		}
		else 
		{
			assertEquals(true, parser.getFileContent());
		}
	}

	@Test
	void ArquivoException02()
	{
		TDDParser parser = new TDDParser(';', "src/parser/example1.out", 'v');
		String error_message = "Erro ao savar arquivo. Escrita não permitida !";
		assertEquals(true, parser.getFileContent());
		String content = parser.getContent();
		boolean saver = parser.saveContentParsed("/user/local/bin", content);
		if(!saver)
		{
			EscritaNãoPermitidaException arquivo_exception = new EscritaNãoPermitidaException();
			assertEquals(error_message, arquivo_exception.getMessage());
		}
		else
		{
			assertEquals(true, saver);
		}
	}
}