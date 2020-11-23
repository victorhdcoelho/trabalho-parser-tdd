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
	
	@Test
	void testOpenFile()
	{
		TDDParser parser = new TDDParser(';', "../parser/analysisTime.out");
		assertEquals("../parser/analysisTime.out", parser.getTargetFile());
		assertEquals(true, parser.getFileContent());
	}

}
