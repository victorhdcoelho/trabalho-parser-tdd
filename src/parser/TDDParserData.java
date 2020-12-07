package parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TDDParserData {
	public List<Integer> analises = new ArrayList<Integer>();
	private List<String> content_file = new ArrayList<String>();
	private String target_file;

	public TDDParserData(String target_file) {
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
}