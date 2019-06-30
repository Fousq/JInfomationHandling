package kz.zhanbolat.jinformation;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import kz.zhanbolat.jinformation.entity.Symbol;

public class SymbolTest {
	private char character;
	
	@Before
	public void init() {
		character = 'n';
	}
	
	@Test
	public void characterShouldBeTheSame() {
		Symbol ch = new Symbol(character);
		ch.show();
		assertTrue(ch.getValue() == character);
	}
	
}
