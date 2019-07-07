package kz.zhanbolat.jinformation.sorter;

import java.util.ArrayList;
import java.util.List;

import kz.zhanbolat.jinformation.comparator.SentanceComparator;
import kz.zhanbolat.jinformation.entity.Paragraph;
import kz.zhanbolat.jinformation.entity.TextComponent;

public class SentanceSorter {
	
	public Paragraph sort(Paragraph unsorted) {
		List<TextComponent> textComponents = new ArrayList<>(unsorted.getTextComponents());
		textComponents.sort(new SentanceComparator());
		Paragraph sorted = new Paragraph();
		textComponents.forEach(textComponent -> sorted.add(textComponent));
		return sorted;
	}
	
}
