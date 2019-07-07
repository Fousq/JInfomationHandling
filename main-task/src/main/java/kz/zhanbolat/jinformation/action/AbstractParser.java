package kz.zhanbolat.jinformation.action;

import java.util.List;

import kz.zhanbolat.jinformation.entity.TextComponent;

public interface AbstractParser {
	List<TextComponent> parse(String text);
}
