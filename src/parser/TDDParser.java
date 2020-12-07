package parser;

import java.io.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class TDDParser {
	private char separator;
	private char position;
	private int evolution;
	private Persistencia content;

	public TDDParser(char separator, String target_file, char position)
	{
		this.separator = separator;
		this.position = position;
		this.content = new Persistencia(target_file);
	}
	
	public char getSeparator()
	{
		return this.separator;
	}
	public String getTargetFile()
	{
		return this.content.getTargetFile();
	}
	
	public int getEvolutions()
	{
		return this.evolution - 1;
	}
	
	public List<Integer> getAnalises()
	{
		return this.content.analises;
	}
	
	public boolean getFileContent()
	{
		return content.getFileContent(this);
	}

	private int getMaxOfList(List<List<String>> times)
	{
		int maxi = -99;
		for(int i=0; i < times.size(); i++)
		{
			if(maxi < times.get(i).size())
			{
				maxi = times.get(i).size();
			}
		}
		return maxi;
	}
	
	private String transposeLine(List<List<String>> times, int maxi)
	{
		String transpose_line = new String("");
		for(int i=0; i < maxi; i++) 
		{
			for(int j=0; j < times.size(); j++)
			{
				try 
				{
				
					transpose_line = transpose_line.concat(
							times.get(j).get(i) + this.separator);
				}
				catch(Exception e)
				{
					transpose_line= transpose_line.concat(String.valueOf(this.separator));
				}
			}
			if(i != maxi -1)
			{
			transpose_line = transpose_line.concat("\n");
			}
		}
		return transpose_line;
	}
	
	private String transform2Vertical(String h_string)
	{
		String result = new String("");
		String columns = new String("");
		String[] list_string = h_string.split(String.valueOf(this.separator));
		List<List<String>> times = new ArrayList<List<String>>();
		List<String> temp_times = new ArrayList<String>();

		for(int i=0; i < list_string.length; i++)
		{
			if(i == 0)
			{
				columns = columns.concat(list_string[i]+this.separator);
			}
			else if(list_string[i].contains("\n"))
			{
				columns = columns.concat(list_string[i].replace("\n", "")+this.separator);
				times.add(temp_times);
				temp_times = new ArrayList<String>();
			}
			else
			{
				temp_times.add(list_string[i]);
			}
			if(i == list_string.length - 1)
			{
				times.add(temp_times);
			}
		}
		int maxi = getMaxOfList(times);
		String transpose_line = transposeLine(times, maxi);
		
		columns = columns.concat("\n");
		result = result.concat(columns);
		result = result.concat(transpose_line);
		return result;
	}
	
	public String clearNonWantChar(String content) 
	{
		content = content.replaceAll(this.separator + "\n", "\n");
		content = content.replaceAll(this.separator+"$", "");
		return content; 
	}
	
	public String getContent() {
		String result = new String("");
		int count = 1;
		int temp = 0;
		for(int i=0; i < this.content.getContent().size(); i++)
		{
			if(this.content.getContent().get(i).contains("-----") && i !=0) 
			{
				result = result.concat("\n");
				this.content.analises.add(temp);
				temp = 0;
			}
			if(this.content.getContent().get(i).contains("-----"))
			{
				String evolution = NumberFormat.getInstance().format(count) + this.separator;
				result = result.concat(evolution);
				count++;
			}
			else 
			{
				result = result.concat(this.content.getContent().get(i) + this.separator);
				temp++;
			}
		}
		this.content.analises.add(temp);
		this.evolution = count;
		if(this.position == 'v')
		{
			String v_result = transform2Vertical(result);
			return clearNonWantChar(v_result);
		}
		return clearNonWantChar(result);
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
