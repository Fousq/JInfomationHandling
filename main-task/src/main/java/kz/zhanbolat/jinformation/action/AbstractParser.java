package kz.zhanbolat.jinformation.action;

import java.util.List;

import kz.zhanbolat.jinformation.entity.TextComponent;
import kz.zhanbolat.jinformation.exception.ParserException;

public interface AbstractParser {
	List<TextComponent> parse(String text);
}
