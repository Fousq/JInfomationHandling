package kz.zhanbolat.jinformation.action;

public abstract class AbstractParser {
	private AbstractParser nextParser;
	
	public void setNextParser(AbstractParser nextParser) {
		this.nextParser = nextParser;
	}
	
	public abstract void parse(String text);
	
}
