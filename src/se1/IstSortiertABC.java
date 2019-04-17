package se1;	

import java.util.Arrays;

public class IstSortiertABC implements IstSortiertInterface {
	
	public String[][] abhang;
	
	@Override
	public boolean abhaengigkeit(String a, String b, String[][] c) {
		for (int i = 0; i<c.length;i++) {
			int aIndex = Arrays.asList(c[i]).indexOf(a);
			int bIndex = Arrays.asList(c[i]).indexOf(b);
			if(aIndex >= 0 && bIndex >= 0 && aIndex>bIndex) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public boolean isWellSorted(String[] sequence) {
		if(sequence.length<=1) //Leere Strings erkennen
			return true;
		for(int i = 0; i<sequence.length-1;i++) {
			if(abhaengigkeit(sequence[i], sequence[i+1], abhang)==false) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void setAbhang(String[][] c) {
		abhang = c;
		
	}

	@Override
	public String[][] getAbhang() {
		return abhang;
	}
}
