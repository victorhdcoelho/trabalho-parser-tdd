package tst;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import parser.TDDParser;

class TstParser {
	
	@Test
	void testParser01() {
		TDDParser parser = new TDDParser();
		assertEquals(';', parser.getSeparator());
	}
	
	@Test
	void testParser02() {
		TDDParser parser = new TDDParser();
		assertEquals(',', parser.getSeparator2());
	}

}
