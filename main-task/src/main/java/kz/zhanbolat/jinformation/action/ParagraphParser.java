package kz.zhanbolat.jinformation.action;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kz.zhanbolat.jinformation.entity.Paragraph;
import kz.zhanbolat.jinformation.entity.TextComponent;
import kz.zhanbolat.jinformation.exception.ParserException;

public class ParagraphParser extends AbstractParser {
	private static Logger logger = LogManager.getLogger(ParagraphParser.class);
	private final static String PARAGRAPH_REGEX = "^[A-Z].*\\.$";
	private static Pattern pattern = Pattern.compile(PARAGRAPH_REGEX, Pattern.MULTILINE);
	private static Matcher matcher;
	
	public List<TextComponent> parse(String text) throws ParserException {
		if (nextParser == null) {
			throw new ParserException("Next parser is not setted.");
		}
		matcher = pattern.matcher(text);
		List<TextComponent> matched = new ArrayList<>();
		while(matcher.find()) {
			Paragraph paragraph = new Paragraph();
			for (TextComponent textComponent : nextParser.parse(matcher.group())) {
				paragraph.add(textComponent);
			}
			matched.add(paragraph);
		}
		return matched;
	}
	
	/**
	 *Method was added to test the regex 
	 */
	public List<String> getMatchedString(String text) {
		matcher = pattern.matcher(text);
		List<String> matched = new ArrayList<>();
		while(matcher.find()) {
			logger.debug(matcher.group());
			matched.add(matcher.group());
		}
		return matched;
	}
	
}
