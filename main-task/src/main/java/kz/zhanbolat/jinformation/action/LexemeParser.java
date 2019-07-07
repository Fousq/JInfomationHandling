package kz.zhanbolat.jinformation.action;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kz.zhanbolat.jinformation.entity.Lexeme;
import kz.zhanbolat.jinformation.entity.TextComponent;
import kz.zhanbolat.jinformation.exception.ParserException;

public class LexemeParser implements AbstractParser {
	private static Logger logger = LogManager.getLogger(LexemeParser.class);
	private static final String LEXEME_REGEX = "\\w+\\b[,\\.\\?!-]";
	private static Pattern pattern = Pattern.compile(LEXEME_REGEX);
	private static Matcher matcher;
	private List<AbstractParser> nextParsers;
	
	public LexemeParser() {
		nextParsers = new ArrayList<>();
		nextParsers.add(new WordParser());
		nextParsers.add(new SymbolParser());
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
			Lexeme lexeme = new Lexeme();
			for (AbstractParser nextParser : nextParsers) {
				for (TextComponent textComponent : nextParser.parse(foundedStr)) {
					lexeme.add(textComponent);
				}
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
		if (matcher.find()) {
			matched.add(matcher.group(0));
		}
		return matched;
	}
	
}
