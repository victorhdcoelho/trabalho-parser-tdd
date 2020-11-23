package parser;

import java.io.IOException;
import java.util.Scanner;

public class ParserMain {

	public static void main(String[] args) throws IOException {
		try (Scanner sc = new Scanner(System.in)) {
			String input = new String("");
			String output = new String("");
			char separator;
			char position;
			
			System.out.println("Entre com o path do documento: ");
			input = sc.nextLine();
			System.out.println("Entre com o separador: ");
			separator = sc.nextLine().charAt(0);
			System.out.println("Digite: h-horinzontal v-vertical");
			position = sc.nextLine().charAt(0);
			System.out.println("Entre com o path de output");
			output = sc.nextLine();
			TDDParser parser = new TDDParser(separator, input, position);
			if (parser.getFileContent())
			{
				String content = parser.getContent();
				if(parser.saveContentParsed(output, content))
				{
					System.out.println("Parser success !!");
				}
				else
				{
					throw new IOException("Erro ao salvar arquivo !!");
				}
			}
			else
			{
				throw new IOException("Erro ao abrir arquivo");
			}
		}
	}

}
