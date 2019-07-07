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

import kz.zhanbolat.jinformation.entity.Sentance;
import kz.zhanbolat.jinformation.entity.TextComponent;
import kz.zhanbolat.jinformation.parser.SentanceParser;

public class SentanceTest {
	private static Logger logger = LogManager.getLogger(Sentance.class);
	private static String text;
	private static SentanceParser parser;
	
	@BeforeClass
	public static void init() {
		parser = new SentanceParser();
		try {
			FileReader reader = new FileReader("data//test//SentanceTestFile.txt");
			int i;
			StringBuilder builder = new StringBuilder();
			while((i = reader.read()) != -1) {
				logger.debug((char) i);
				builder.append((char) i);
			}
			text = builder.toString();
		} catch (IOException e) {
			logger.error("Error in reading from file.", e);
			text = "";
		}
	}
	
	@Test
	@Ignore
	public void regexTest() {
		List<String> matched = parser.getMatched(text);
		logger.debug(matched);
		assertTrue(matched.size() != 0);
	}
	
	@Test
	public void parseShouldWorkCorrectly() {
		List<TextComponent> sentances = parser.parse(text);
		assertTrue(sentances.size() != 0);
		logger.debug(sentances.get(0).build());
	}
	
}
