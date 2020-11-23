package tst;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

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
	void testParserContent01()
	{
		String result = "1;439;705;\n2;470;828;760;";
		TDDParser parser = new TDDParser(';', "src/parser/example1.out", 'h');
		assertEquals(true, parser.getFileContent());
		assertEquals(result, parser.getContent());
	}
	
	@Test
	void testParserContent02()
	{
		String result = "1;439;705;444;\n2;470;828;";
		TDDParser parser = new TDDParser(';', "src/parser/example2.out", 'h');
		assertEquals(true, parser.getFileContent());
		assertEquals(result, parser.getContent());
	}
	
	@Test
	void testParserContent03()
	{
		String result = "1;439;705;444;\n2;470;828;111;";
		TDDParser parser = new TDDParser(';', "src/parser/example3.out", 'h');
		assertEquals(true, parser.getFileContent());
		assertEquals(result, parser.getContent());
	}
	
	@Test
	void testParserContentVertical01()
	{
		TDDParser parser = new TDDParser(';', "src/parser/example1.out", 'v');
		assertEquals(true, parser.getFileContent());
		assertEquals("1;2;\n123;321;\n123;321;\n123;321;", parser.getContent());
	}
}
