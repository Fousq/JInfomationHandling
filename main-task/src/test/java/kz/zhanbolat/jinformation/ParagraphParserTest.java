package kz.zhanbolat.jinformation;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import kz.zhanbolat.jinformation.entity.Paragraph;
import kz.zhanbolat.jinformation.entity.TextComponent;
import kz.zhanbolat.jinformation.parser.ParagraphParser;
import kz.zhanbolat.jinformation.sorter.SentanceSorter;

public class ParagraphParserTest {
	private static Logger logger = LogManager.getLogger(ParagraphParserTest.class);
	private FileReader reader;
	private StringBuilder builder;
	private String text;
	private ParagraphParser parser;
	
	@Before
	public void init() {
		try {
			reader = new FileReader("data\\test\\ParagraphParserData.txt");
		} catch (FileNotFoundException e) {
			logger.error("File not found", e);
		}
		builder = new StringBuilder();
		try {
			int i;
			while((i = reader.read()) != -1) {
				logger.debug((char) i);
				builder.append((char) i);
			}
		text = builder.toString();
		} catch (IOException e) {
			logger.error("IO error", e);
		}
		parser = new ParagraphParser();
	}
	
	@Test
	@Ignore
	public void getMatchedStringMustWordCorrectly() {
		List<String> matched = parser.getMatchedString(text);
		logger.debug(matched);
		assertTrue(matched.size() != 0);
	}
	
	@Test
	@Ignore
	public void parseShouldWordCorrectly() {
		List<TextComponent> paragraphs = parser.parse(text);
		paragraphs.forEach(paragraph -> logger.debug(paragraph.build()));
		assertTrue(paragraphs.size() != 0);
	}
	
	@Test
	public void sentanceComparatorTest() {
		List<TextComponent> paragraphs = parser.parse(text);
		List<TextComponent> sortedParagraphs = new ArrayList<>();
		for (TextComponent textComponent : paragraphs) {
			sortedParagraphs.add(new SentanceSorter().sort((Paragraph)textComponent));
		}
		paragraphs.forEach(paragraph -> logger.debug(paragraph.build()));
		sortedParagraphs.forEach(paragraph -> logger.debug(paragraph.build()));
		assertTrue(paragraphs.size() == sortedParagraphs.size());
	}
	
}
