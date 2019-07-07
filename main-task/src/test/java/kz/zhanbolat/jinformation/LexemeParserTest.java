package kz.zhanbolat.jinformation;

import static org.junit.Assert.assertTrue;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import kz.zhanbolat.jinformation.action.LexemeParser;
import kz.zhanbolat.jinformation.action.SymbolParser;
import kz.zhanbolat.jinformation.action.WordParser;
import kz.zhanbolat.jinformation.entity.TextComponent;
import kz.zhanbolat.jinformation.exception.ParserException;

public class LexemeParserTest {
	private static Logger logger = LogManager.getLogger(LexemeParserTest.class);
	private static String text;
	private static LexemeParser parser;
	
	@BeforeClass
	public static void init() {
		parser = new LexemeParser();
		parser.add(new WordParser());
		parser.add(new SymbolParser());
		try {
			FileReader reader = new FileReader("data//test//LexemeTestFile.txt");
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
	public void testRegEx() {
		List<String> matched = parser.getMatched(text);
		logger.debug(matched);
		assertTrue(matched.size() != 0);
	}
	
	@Test
	public void parseShouldWorkCorrectly() {
		List<TextComponent> lexemes = parser.parse(text);
		lexemes.forEach(lexeme -> logger.debug(lexeme.build()));
		assertTrue(lexemes.size() != 0);
	}
	
}
