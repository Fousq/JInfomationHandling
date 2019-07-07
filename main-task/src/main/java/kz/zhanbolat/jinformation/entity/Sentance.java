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
	
	@Override
	public String build() {
		StringBuilder builder = new StringBuilder();
		for (TextComponent textComponent : textComponents) {
			String str = textComponent.build();
			if (textComponent instanceof Lexeme) {
				String word = str.split("[\\.,'\\?!-]", 2)[0];
				int i;
				if (str.endsWith(".") || str.endsWith("'") || 
					str.endsWith("'.") || str.endsWith("',")) {
					i = builder.lastIndexOf(word);
				} else {
					i = builder.indexOf(word);
				}
				builder.replace(i, i + word.length(), str);
			} else {
				builder.append(str);
				builder.append(" ");
			}
		}
		return builder.toString();
	}
}
