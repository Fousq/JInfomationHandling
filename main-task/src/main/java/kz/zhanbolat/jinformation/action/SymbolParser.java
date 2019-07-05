package kz.zhanbolat.jinformation.action;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kz.zhanbolat.jinformation.entity.Symbol;
import kz.zhanbolat.jinformation.entity.TextComponent;

public class SymbolParser extends AbstractParser {
	private static final String SYMBOL_REGEX = "[\\.\\s,\\?!-]";
	private static Pattern pattern = Pattern.compile(SYMBOL_REGEX);
	private static Matcher matcher;
	
	@Override
	public List<TextComponent> parse(String text) {
		matcher = pattern.matcher(text);
		List<TextComponent> matched = new ArrayList<>();
		while (matcher.find()) {
			matched.add(new Symbol(matcher.group().charAt(0)));
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
