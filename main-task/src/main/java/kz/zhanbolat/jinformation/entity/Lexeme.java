package kz.zhanbolat.jinformation.entity;

import java.util.ArrayList;
import java.util.List;

public class Lexeme implements TextComponent {
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
			builder.append(textComponent.build());
		}
		return builder.toString();
	}
}
