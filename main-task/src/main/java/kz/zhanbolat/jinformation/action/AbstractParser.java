package kz.zhanbolat.jinformation.action;

import java.util.List;

import kz.zhanbolat.jinformation.entity.TextComponent;
import kz.zhanbolat.jinformation.exception.ParserException;

public abstract class AbstractParser {
	protected AbstractParser nextParser;
	
	public void setNextParser(AbstractParser nextParser) {
		this.nextParser = nextParser;
	}

	public abstract List<TextComponent> parse(String text) throws ParserException;
	
}
