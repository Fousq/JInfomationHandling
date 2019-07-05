package kz.zhanbolat.jinformation.entity;

import java.util.ArrayList;
import java.util.List;

public class Word implements TextComponent {
	private List<TextComponent> textComponents = new ArrayList<>();
	private String value;
	
	public Word() {
		
	}
	
	public Word(String value) {
		this.value = value;
	}
	
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
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String build() {
		return value;
	}
}
