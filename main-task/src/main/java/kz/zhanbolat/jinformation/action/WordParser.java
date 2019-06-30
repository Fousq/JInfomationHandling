package kz.zhanbolat.jinformation.action;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kz.zhanbolat.jinformation.entity.TextComponent;
import kz.zhanbolat.jinformation.entity.Word;
import kz.zhanbolat.jinformation.exception.ParserException;

public class WordParser extends AbstractParser {
	private static final String WORD_REGEX = "\\w+";
	private static Pattern pattern = Pattern.compile(WORD_REGEX);
	private static Matcher matcher;
	
	@Override
	public List<TextComponent> parse(String text) throws ParserException {
		if (nextParser == null) {
			throw new ParserException("Next parser is not setted.");
		}
		matcher = pattern.matcher(text);
		List<TextComponent> matched = new ArrayList<>();
		while (matcher.find()) {
			Word word = new Word();
			for (TextComponent textComponent : nextParser.parse(matcher.group())) {
				word.add(textComponent);
			}
			matched.add(word);
		}
		return matched;
	}

}
