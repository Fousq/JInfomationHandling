package kz.zhanbolat.jinformation.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Sentance implements TextComponent {
	private static Logger logger = LogManager.getLogger(Sentance.class);
	private List<TextComponent> textComponents = new ArrayList<>();
	
	public void add(TextComponent textComponent) {
		textComponents.add(textComponent);
	}
	
	public TextComponent getChild(int index) {
		return textComponents.get(index);
	}
	
	public void remove(int index) {
		textComponents.remove(index);
	}
	
	public void remove(TextComponent textComponent) {
		textComponents.remove(textComponent);
	}
	
	@Override
	public String build() {
		StringBuilder builder = new StringBuilder();
		for (TextComponent textComponent : textComponents) {
			String str = textComponent.build();
			if (textComponent instanceof Lexeme) {
				String word = str.substring(0, str.length() - 2);
				int i = builder.indexOf(word);
				builder.replace(i, i + str.length(), str + " ");
			} else {
				builder.append(str);
				builder.append(" ");
			}
		}
		return builder.toString();
	}
}
