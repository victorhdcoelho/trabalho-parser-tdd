package parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Persistencia {
	public List<Integer> analises = new ArrayList<Integer>();
	private List<String> content_file = new ArrayList<String>();
	private String target_file;

	public Persistencia(String target_file) {
		this.target_file = target_file;
	}

	public String getTargetFile() {
		return this.target_file;
	}
	public List<String> getContent()
	{
		return this.content_file;
	}
	
	public boolean getFileContent(TDDParser tddParser)
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(this.target_file));
			String line;
			while((line = reader.readLine()) != null)
			{
				content_file.add(line);
			}
			reader.close();
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean saveContentParsed(String out_path, String content_parsed) {
		try
		{
			FileWriter writer = new FileWriter(out_path);
			writer.write(content_parsed);
			writer.close();
			return true;
		}
		catch(IOException e)
		{
			return false;
		}
	}
}