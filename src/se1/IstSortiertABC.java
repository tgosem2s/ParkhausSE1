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
		if(multiTasksCheck(sequence)==true)
			return false;
		for(int i = 0; i<sequence.length-1;i++) {
			for(int j = i+1; j<sequence.length; j++) {
				if(abhaengigkeit(sequence[i], sequence[j], abhang)==false) {
					return false;
			}
			}
		}
		return true;
	}
	
	public boolean multiTasksCheck(String[] s) { //Check ob in der Sequenz Tasks mehrfach sind
		for(int i = 0; i<s.length-1; i++) {
			for(int j = i+1; j<s.length; j++) {
				if(s[i].equals(s[j])) {
					return true;
				}
			}
		}
		return false;
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
