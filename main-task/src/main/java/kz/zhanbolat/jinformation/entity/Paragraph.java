package kz.zhanbolat.jinformation.entity;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements TextComponent {
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
			builder.append(textComponent.build());
		}
		return builder.toString();
	}
}
