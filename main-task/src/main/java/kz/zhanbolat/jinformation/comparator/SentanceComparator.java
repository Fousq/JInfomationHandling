package kz.zhanbolat.jinformation.comparator;

import java.util.Comparator;

import kz.zhanbolat.jinformation.action.WordCounter;
import kz.zhanbolat.jinformation.entity.TextComponent;

public class SentanceComparator implements Comparator<TextComponent> {

	@Override
	public int compare(TextComponent o1, TextComponent o2) {
		return (int)(WordCounter.count(o1.build()) - WordCounter.count(o2.build()));
	}

}
