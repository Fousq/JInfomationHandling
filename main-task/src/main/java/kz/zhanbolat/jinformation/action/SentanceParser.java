package kz.zhanbolat.jinformation.action;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kz.zhanbolat.jinformation.entity.Sentance;
import kz.zhanbolat.jinformation.entity.TextComponent;

public class SentanceParser implements AbstractParser {
	private static Logger logger = LogManager.getLogger(SentanceParser.class);
	private static final String SENTANCE_REGEX = "[A-Z][^.]*\\.";
	private static Pattern pattern = Pattern.compile(SENTANCE_REGEX);
	private static Matcher matcher;
	private static int counter = 0;
	private List<AbstractParser> nextParsers;
	
	public SentanceParser() {
		nextParsers = new ArrayList<>();
		nextParsers.add(new WordParser());
		nextParsers.add(new LexemeParser());
	}
	
	public void add(AbstractParser nextParser) {
		if (nextParsers.contains(nextParser)) {
			logger.warn("Such parser was added to the chain before.");
			return;
		}
		nextParsers.add(nextParser);
	}
	
	@Override
	public List<TextComponent> parse(String text) {
		matcher = pattern.matcher(text);
		List<TextComponent> matched = new ArrayList<>();
		while(matcher.find()) {
			String foundedStr = matcher.group();
			logger.debug(foundedStr);
			Sentance sentance = new Sentance();
			for (AbstractParser nextParser : nextParsers) {
				for (TextComponent textComponent : nextParser.parse(foundedStr)) {
					sentance.add(textComponent);
				}
			}
			logger.info("Count of created sentances: " + ++counter);
			matched.add(sentance);
		}
		return matched;
	}
	
	/**
	 *Method was added to test the regex 
	 */
	public List<String> getMatched(String text) {
		matcher = pattern.matcher(text);
		List<String> matched = new ArrayList<>();
		while (matcher.find()) {
			matched.add(matcher.group());
		}
		return matched;
	}
	
}
