package se1;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SortedTest {
	
	private IstSortiertInterface isIF;
	
	@Before
	public void setUp() throws Exception {
		isIF = new IstSortiertABC();
		isIF.setAbhang(new String[][]{{ "A" , "C" }, { "C", "D" }, { "B", "C" }});
	}
	
	@Test
	public void isWellSorted_Uebungsbeispiele_TrueandFalse() {
		assertTrue (isIF.isWellSorted(new String[]{ "A" , "B", "C", "D" }));
		assertFalse (isIF.isWellSorted(new String[]{ "D" , "C", "B", "A" }));
	}
	
	@Test
	public void isWellSorted_LeererString_True() {
		assertTrue (isIF.isWellSorted(new String[] {""}));
	}
	
	@Test
	public void isWellSorted_DoppelteTask_False() {
		assertFalse (isIF.isWellSorted(new String[] {"A" , "A", "C", "D"}));
		assertFalse (isIF.isWellSorted(new String[] {"A" , "B", "B", "D"}));
		assertFalse (isIF.isWellSorted(new String[] {"A" , "B", "D", "D"}));
	}
	
	@Test
	public void isWellSorted_KompletterString_TrueandFalse() {
		assertFalse (isIF.isWellSorted(new String[] {"C" ,"D", "A"}));
		assertTrue (isIF.isWellSorted(new String[] {"A" ,"B", "D"}));
	}
	
	@Test
	public void isWellSorted_Transitiv_TrueandFalse() {
		assertFalse (isIF.isWellSorted(new String[] {"D" ,"A"}));
		assertFalse (isIF.isWellSorted(new String[] {"D" ,"B"}));
		assertTrue (isIF.isWellSorted(new String[] {"A" ,"D"}));
		assertTrue (isIF.isWellSorted(new String[] {"B" ,"D"}));
	}
}

