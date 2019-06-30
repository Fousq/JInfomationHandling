package kz.zhanbolat.jinformation.action;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kz.zhanbolat.jinformation.entity.Symbol;
import kz.zhanbolat.jinformation.entity.TextComponent;

public class SymbolParser extends AbstractParser {
	private static final String SYMBOL_REGEX = ".";
	private static Pattern pattern = Pattern.compile(SYMBOL_REGEX);
	private static Matcher matcher;
	
	@Override
	public List<TextComponent> parse(String text) {
		matcher = pattern.matcher(text);
		List<TextComponent> matched = new ArrayList<>();
		while (matcher.find()) {
			Symbol symbol = new Symbol(matcher.group().charAt(0));
			matched.add(symbol);
		}
		return matched;
	}

}
