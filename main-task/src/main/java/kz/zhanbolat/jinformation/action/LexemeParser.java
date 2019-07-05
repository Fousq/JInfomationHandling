package kz.zhanbolat.jinformation.action;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kz.zhanbolat.jinformation.entity.Lexeme;
import kz.zhanbolat.jinformation.entity.TextComponent;
import kz.zhanbolat.jinformation.exception.ParserException;

public class LexemeParser extends AbstractParser {
	private static final String LEXEME_REGEX = "\\w+\\b([,\\.]\\s|\\s|\\?|!|-)";
	private static Pattern pattern = Pattern.compile(LEXEME_REGEX);
	private static Matcher matcher;
	
	@Override
	public List<TextComponent> parse(String text) throws ParserException {
		if (nextParser == null) {
			throw new ParserException("Next parser is not setted");
		}
		matcher = pattern.matcher(text);
		List<TextComponent> matched = new ArrayList<>();
		while(matcher.find()) {
			Lexeme lexeme = new Lexeme();
			for (TextComponent textComponent : nextParser.parse(matcher.group(0))) {
				lexeme.add(textComponent);
			}
			setNextParser(new SymbolParser());
			for (TextComponent textComponent : nextParser.parse(matcher.group(1))) {
				lexeme.add(textComponent);
			}
			matched.add(lexeme);
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
