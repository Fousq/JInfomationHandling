package kz.zhanbolat.jinformation;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import kz.zhanbolat.jinformation.action.ParagraphParser;

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
		builder.append("It has survived not only five centuries, but also the ");
		builder.append("leap into electronic typesetting, remaining essentially");
		builder.append(" unchanged.");
		builder.append(System.lineSeparator());
		builder.append("It is a long established fact that a reader will be");
		builder.append(" distracted by the readable content of a page when");
		builder.append(" looking at its layout.");
		text = builder.toString();
		parser = new ParagraphParser();
	}
	
	@Test
	public void getMatchedStringMustWordCorrectly() {
		List<String> matched = parser.getMatchedString(text);
		logger.debug(matched);
		assertTrue(matched.size() != 0);
		builder = new StringBuilder();
		try {
			int i;
			while((i = reader.read()) != -1) {
				logger.debug((char) i);
				builder.append((char) i);
			}
		} catch (IOException e) {
			logger.error("IO error", e);
		}
		text = builder.toString();
		matched = parser.getMatchedString(text);
		logger.debug(matched);
		assertTrue(matched.size() != 0);
	}
	
}
