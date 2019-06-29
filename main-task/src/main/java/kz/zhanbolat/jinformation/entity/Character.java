package kz.zhanbolat.jinformation.entity;

public class Character implements TextComponent {
	private char value;

	public Character(char value) {
		this.value = value;
	}
	
	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}

	@Override
	public void show() {
		System.out.print(value);
	};
	
}
