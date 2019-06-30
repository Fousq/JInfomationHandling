package kz.zhanbolat.jinformation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import kz.zhanbolat.jinformation.entity.Lexeme;
import kz.zhanbolat.jinformation.entity.Paragraph;
import kz.zhanbolat.jinformation.entity.Sentance;
import kz.zhanbolat.jinformation.entity.Symbol;
import kz.zhanbolat.jinformation.entity.Word;

public class EntityTest {
	private static Logger logger = LogManager.getLogger(EntityTest.class);
	
	@Test
	public void test() {
		Paragraph paragraph = new Paragraph();
		Sentance sentance = new Sentance();
		Lexeme lexeme = new Lexeme();
		Word word = new Word();
		String text = "\tIt has survived not only five centuries, but also the leap into electronic\r\n" + 
				"typesetting, remaining essentially unchanged.";
		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			logger.debug(ch);
			word.add(new Symbol(ch));
		}
		lexeme.add(word);
		sentance.add(lexeme);
		paragraph.add(sentance);
		word.show();
		lexeme.show();
		sentance.show();
		paragraph.show();
	}
	
}
