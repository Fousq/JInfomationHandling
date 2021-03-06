package kz.zhanbolat.jinformation;

import static org.junit.Assert.assertTrue;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import kz.zhanbolat.jinformation.entity.TextComponent;
import kz.zhanbolat.jinformation.parser.SymbolParser;

public class SymbolTest {
	private static Logger logger = LogManager.getLogger(SymbolTest.class);
	private static String text;
	private static SymbolParser parser;
	
	@BeforeClass
	public static void init() {
		parser = new SymbolParser();
		try {
			FileReader reader = new FileReader("data//test//SymbolTestFile.txt");
			int i;
			StringBuilder builder = new StringBuilder();
			while((i = reader.read()) != -1) {
				logger.debug((char) i);
				builder.append((char) i);
			}
			text = builder.toString();
		} catch(IOException e) {
			logger.error("Error in reading from file.", e);
			text = "";
		}
	}
	
	@Test
	@Ignore
	public void testRegEx() {
		List<String> matched = parser.getMatched(text);
		logger.debug(matched);
		assertTrue(matched.size() != 0);
	}
	
	@Test
	public void parserShouldWorkCorrectly() {
		List<TextComponent> symbols = parser.parse(text);
		symbols.forEach(symbol -> logger.debug(symbol.build()));
		assertTrue(symbols.size() != 0);
	}
	
}
