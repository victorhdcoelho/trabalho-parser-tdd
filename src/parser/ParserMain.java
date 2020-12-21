package parser;

import java.util.List;
import java.util.Scanner;

public class ParserMain {

	public static void main(String[] args) throws Exception {
		try (Scanner sc = new Scanner(System.in)) {
			String input = new String("");
			String output = new String("");
			String separator;
			char separator_char;
			char position;
			
			System.out.println("Entre com o path do documento: ");
			input = sc.nextLine();
			System.out.println("Entre com o separador: ");
			separator = sc.nextLine();
			if(separator.length() > 1)
			{
				throw new DelimitadorInvalidoException();
			}
			else 
			{
				separator_char = separator.charAt(0);
			}
			System.out.println("Digite: h-horinzontal v-vertical");
			position = sc.nextLine().charAt(0);
			System.out.println("Entre com o path de output");
			output = sc.nextLine();
			TDDParser parser = new TDDParser(separator_char, input, position);
			if (parser.getFileContent())
			{
				String content = parser.getContent();
				if(parser.saveContentParsed(output, content))
				{
					System.out.println("Parser success !!");
					System.out.printf("Número de evoluções %d\n", parser.getEvolutions());
					List<Integer> analises = parser.getAnalises();
					for(int i=0; i < analises.size(); i ++)
					{
						System.out.printf("Evolução %d: %d analises\n", i+1, analises.get(i));
					}
				}
				else
				{
					throw new EscritaNãoPermitidaException();
				}
			}
			else
			{
				throw new ArquivoNaoEncontradoException();
			}
		}
	}

}
