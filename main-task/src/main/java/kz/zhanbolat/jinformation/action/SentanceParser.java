package kz.zhanbolat.jinformation.action;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kz.zhanbolat.jinformation.entity.Sentance;
import kz.zhanbolat.jinformation.entity.TextComponent;
import kz.zhanbolat.jinformation.exception.ParserException;

public class SentanceParser extends AbstractParser {
	private static final String SENTANCE_REGEX = "[^.]*\\.";
	private static Pattern pattern = Pattern.compile(SENTANCE_REGEX);
	private static Matcher matcher;
	
	@Override
	public List<TextComponent> parse(String text) throws ParserException {
		if (nextParser == null) {
			throw new ParserException("Next parser is not setted");
		}
		matcher = pattern.matcher(text);
		List<TextComponent> matched = new ArrayList<>();
		while(matcher.find()) {
			Sentance sentance = new Sentance();
			for (TextComponent textComponent : nextParser.parse(matcher.group())) {
				sentance.add(textComponent); 
			}
			matched.add(sentance);
		}
		return matched;
	}

}
