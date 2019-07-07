package kz.zhanbolat.jinformation.action;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kz.zhanbolat.jinformation.entity.TextComponent;
import kz.zhanbolat.jinformation.entity.Word;
import kz.zhanbolat.jinformation.exception.ParserException;

public class WordParser implements AbstractParser {
	private static final String WORD_REGEX = "\\w+";
	private static Pattern pattern = Pattern.compile(WORD_REGEX);
	private static Matcher matcher;
	
	@Override
	public List<TextComponent> parse(String text) {
		matcher = pattern.matcher(text);
		List<TextComponent> matched = new ArrayList<>();
		while (matcher.find()) {
			matched.add(new Word(matcher.group()));
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
