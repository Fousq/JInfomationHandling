package kz.zhanbolat.jinformation.entity;

public class Symbol implements TextComponent {
	private char value;

	public Symbol() {
		super();
	}
	
	public Symbol(char value) {
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
