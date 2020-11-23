package tst;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import parser.TDDParser;

class TstParser {
	// Triangulação
	
	@Test
	void testParser01() {
		TDDParser parser = new TDDParser(';', null, 'h');
		assertEquals(';', parser.getSeparator());
	}
	
	@Test
	void testParser02() {
		TDDParser parser = new TDDParser(',', null, 'h');
		assertEquals(',', parser.getSeparator());
	}
	
	@Test
	void testParser03() {
		TDDParser parser = new TDDParser('\n', null, 'h');
		assertEquals('\n', parser.getSeparator());
	}
	
	// Triangulação
	@Test
	void testOpenFile01()
	{
		TDDParser parser = new TDDParser(';', "src/parser/analysisTime.out", 'h');
		assertEquals("src/parser/analysisTime.out", parser.getTargetFile());
		assertEquals(true, parser.getFileContent());
	}

	@Test
	void testOpenFile02()
	{
		TDDParser parser = new TDDParser(';', "src/parser/totalTime.out", 'h');
		assertEquals("src/parser/totalTime.out", parser.getTargetFile());
		assertEquals(true, parser.getFileContent());
	}
	
	@Test
	void testOpenFile03()
	{
		TDDParser parser = new TDDParser(';', "src/parser/non_file.out", 'h');
		assertEquals("src/parser/non_file.out", parser.getTargetFile());
		assertEquals(false, parser.getFileContent());
	}
	
	// Triangulação
	@Test
	void testParserContentHorizontal01()
	{
		String result = "1;439;705\n2;470;828;760";
		TDDParser parser = new TDDParser(';', "src/parser/example1.out", 'h');
		assertEquals(true, parser.getFileContent());
		assertEquals(result, parser.getContent());
	}
	
	@Test
	void testParserContentHorizontal02()
	{
		String result = "1;439;705;444\n2;470;828";
		TDDParser parser = new TDDParser(';', "src/parser/example2.out", 'h');
		assertEquals(true, parser.getFileContent());
		assertEquals(result, parser.getContent());
	}
	
	@Test
	void testParserContentHorizontal03()
	{
		String result = "1;439;705;444\n2;470;828;111";
		TDDParser parser = new TDDParser(';', "src/parser/example3.out", 'h');
		assertEquals(true, parser.getFileContent());
		assertEquals(result, parser.getContent());
	}
	
	// Triangulação
	@Test
	void testParserContentVertical01()
	{	
		String result = "1;2\n439;470\n705;828\n;760";
		TDDParser parser = new TDDParser(';', "src/parser/example1.out", 'v');
		assertEquals(true, parser.getFileContent());
		assertEquals(result, parser.getContent());
	}
	
	@Test
	void testParserContentVertical02()
	{	
		String result = "1\t2\n439\t470\n705\t828\n444\t";
		TDDParser parser = new TDDParser('\t', "src/parser/example2.out", 'v');
		assertEquals(true, parser.getFileContent());
		assertEquals(result, parser.getContent());
	}
	
	@Test
	void testParserContentVertical03()
	{	
		String result = "1,2\n439,470\n705,828\n444,111";
		TDDParser parser = new TDDParser(',', "src/parser/example3.out", 'v');
		assertEquals(true, parser.getFileContent());
		assertEquals(result, parser.getContent());
	}
	
	// Triangulação
	@Test
	void testSaveContentParsed01() throws IOException
	{
		String content_parsed = new String("");
		TDDParser parser = new TDDParser(';', "src/parser/analysisTime.out", 'v');
		assertEquals(true, parser.getFileContent());
		content_parsed = parser.getContent();
		assertEquals(true, parser.saveContentParsed("src/parser/result1.out", content_parsed));
	}
	
	@Test
	void testSaveContentParsed02() throws IOException
	{
		String content_parsed = new String("");
		TDDParser parser = new TDDParser(';', "src/parser/totalTime.out", 'v');
		assertEquals(true, parser.getFileContent());
		content_parsed = parser.getContent();
		assertEquals(true, parser.saveContentParsed("src/parser/result2.out", content_parsed));
	}
	
	@Test
	void testSaveContentParsed03() throws IOException
	{
		String content_parsed = new String("");
		TDDParser parser = new TDDParser(';', "src/parser/example3.out", 'v');
		assertEquals(true, parser.getFileContent());
		content_parsed = parser.getContent();
		assertEquals(true, parser.saveContentParsed("src/parser/result3.out", content_parsed));
	}
}
