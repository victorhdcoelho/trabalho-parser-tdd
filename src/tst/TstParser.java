package tst;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import parser.TDDParser;

class TstParser {
	// Triangulação
	
	@Test
	void testParser01() {
		TDDParser parser = new TDDParser(';', null);
		assertEquals(';', parser.getSeparator());
	}
	
	@Test
	void testParser02() {
		TDDParser parser = new TDDParser(',', null);
		assertEquals(',', parser.getSeparator());
	}
	
	@Test
	void testParser03() {
		TDDParser parser = new TDDParser('\n', null);
		assertEquals('\n', parser.getSeparator());
	}
	
	// Triangulação
	@Test
	void testOpenFile01()
	{
		TDDParser parser = new TDDParser(';', "src/parser/analysisTime.out");
		assertEquals("src/parser/analysisTime.out", parser.getTargetFile());
		assertEquals(true, parser.getFileContent());
	}

	@Test
	void testOpenFile02()
	{
		TDDParser parser = new TDDParser(';', "src/parser/totalTime.out");
		assertEquals("src/parser/totalTime.out", parser.getTargetFile());
		assertEquals(true, parser.getFileContent());
	}
	
	@Test
	void testOpenFile03()
	{
		TDDParser parser = new TDDParser(';', "src/parser/non_file.out");
		assertEquals("src/parser/non_file.out", parser.getTargetFile());
		assertEquals(false, parser.getFileContent());
	}
}
