package parser;

import java.io.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class TDDParser {
	private char separator;
	private String target_file;
	private char position;
	private List<String> content_file = new ArrayList<String>();
	
	public TDDParser(char separator, String target_file, char position)
	{
		this.separator = separator;
		this.target_file = target_file;
		this.position = position;
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
		String result = new String("");
		int count = 1;
		for(int i=0; i < this.content_file.size(); i++)
		{
			if(this.content_file.get(i).contains("-----") && i !=0) 
			{
				result = result.concat("\n");
			}
			if(this.content_file.get(i).contains("-----"))
			{
				String evolution = NumberFormat.getInstance().format(count) + this.separator; 
				result = result.concat(evolution);
				count++;
			}
			else 
			{
				result = result.concat(this.content_file.get(i) + this.separator);
			}
		}
		return result;
	}
}
