package kz.zhanbolat.jinformation.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {
	private static Pattern pattern = Pattern.compile(WordParser.WORD_REGEX);
	private static Matcher matcher;
	
	public static long count(String text) {
		matcher = pattern.matcher(text);
		long counter = 0;
		while(matcher.find()) {
			counter++;
		}
		return counter;
	}
	
}
