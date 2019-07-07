package kz.zhanbolat.jinformation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kz.zhanbolat.jinformation.entity.Paragraph;
import kz.zhanbolat.jinformation.entity.TextComponent;
import kz.zhanbolat.jinformation.parser.AbstractParser;
import kz.zhanbolat.jinformation.parser.ParagraphParser;
import kz.zhanbolat.jinformation.sorter.SentanceSorter;

/**
 * Hello world!
 *
 */
public class App {
	private static Logger logger = LogManager.getLogger(App.class);
	
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        try {
        	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        	logger.info("Enter the path of file to read from: ");
        	FileReader reader = new FileReader(bf.readLine());
        	int i;
        	while((i = reader.read()) != -1) {
        		builder.append((char)i);
        	}
        } catch (IOException e) {
        	logger.error("Error in IO system.", e);
        	return;
        }
        String text = builder.toString();
        logger.info("Data from the file: ", text);
        logger.info("Starting parsing from the paragraph parser...");
        AbstractParser parser = new ParagraphParser();
        List<TextComponent> parsedText = parser.parse(text);
        for (int i = 0; i < parsedText.size(); i++) {
        	logger.info(i + 1 + " paragraph: ");
        	logger.info(parsedText.get(i).build());
        }
        logger.info("Staring the sorting of sentence of every paragraph...");
        List<TextComponent> sortedParagraphs = new ArrayList<>();
        SentanceSorter sorter = new SentanceSorter();
        for (TextComponent paragraph : parsedText) {
        	sortedParagraphs.add(sorter.sort((Paragraph) paragraph));
        }
        logger.info("Sorted paragraphs: ");
        sortedParagraphs.forEach(paragraph -> logger.info(paragraph.build()));
    }
    
}
