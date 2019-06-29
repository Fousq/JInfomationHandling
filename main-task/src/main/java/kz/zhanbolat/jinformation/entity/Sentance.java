package kz.zhanbolat.jinformation.entity;

import java.util.ArrayList;
import java.util.List;

public class Sentance implements TextComponent {
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
	public void show() {
		for (TextComponent textComponent : textComponents) {
			textComponent.show();
		}
	}
}
