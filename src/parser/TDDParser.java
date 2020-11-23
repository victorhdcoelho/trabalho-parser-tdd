package parser;

import java.io.*;
import java.util.List;

public class TDDParser {
	private char separator;
	private String target_file;
	private List<String> content_file;
	
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
		return true; // Falsificação 
	}
}
