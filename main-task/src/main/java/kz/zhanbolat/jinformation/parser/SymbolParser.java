package kz.zhanbolat.jinformation.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kz.zhanbolat.jinformation.entity.Symbol;
import kz.zhanbolat.jinformation.entity.TextComponent;

public class SymbolParser implements AbstractParser {
	private static Logger logger = LogManager.getLogger(SymbolParser.class);
	private static final String SYMBOL_REGEX = "[\\.,\\?!'-]+";
	private static Pattern pattern = Pattern.compile(SYMBOL_REGEX);
	private static Matcher matcher;
	private static int counter = 0;
	
	@Override
	public List<TextComponent> parse(String text) {
		matcher = pattern.matcher(text);
		List<TextComponent> matched = new ArrayList<>();
		while (matcher.find()) {
			logger.info("Count of created symbols: " + ++counter);
			char[] chars = matcher.group().toCharArray();
			for (int i = 0; i < chars.length; i++) {
				matched.add(new Symbol(chars[i]));
			}
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
			matched.add(String.valueOf(matcher.group().charAt(0)));
		}
		return matched;
	}
	
}
