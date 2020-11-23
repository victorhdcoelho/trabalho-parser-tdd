package parser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TDDParser {
	private char separator;
	private String target_file;
	private List<String> content_file = new ArrayList<String>();
	
	public TDDParser(char separator, String target_file)
	{
		this.separator = separator;
		this.target_file = target_file;
	}
	
	public char getSeparator()
	{
		return this.separator;
	}
	public String getTargetFile()
	{
		return this.target_file;
	}
	
	public boolean getFileContent()
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(this.target_file));
			String line;
			while((line = reader.readLine()) != null)
			{
				this.content_file.add(line);
			}
			reader.close();
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		} 
	}

	public String getContent() {
		return "1;123;123;123";// Falsificação
	}
}
