package se1;

import java.util.Arrays;

public class IstSortiertABC implements IstSortiertInterface {

	public String[][] abhang;
	public String[][] transRegeln;

	@Override
	public boolean abhaengigkeit(String a, String b, String[][] c) {
		for (int i = 0; i < c.length; i++) {
			int aIndex = Arrays.asList(c[i]).indexOf(a);
			int bIndex = Arrays.asList(c[i]).indexOf(b);
			if (aIndex >= 0 && bIndex >= 0 && aIndex > bIndex) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isWellSorted(String[] sequence) {
		if (sequence.length <= 1) // Leere Strings erkennen
			return true;
		if (multiTasksCheck(sequence) == true)
			return false;
		transAbhang();
		for (int i = 0; i < sequence.length - 1; i++) {
			for (int j = i + 1; j < sequence.length; j++) {
				if (abhaengigkeit(sequence[i], sequence[j], transRegeln) == false) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean multiTasksCheck(String[] s) { // Check ob in der Sequenz Tasks mehrfach sind
		for (int i = 0; i < s.length - 1; i++) {
			for (int j = i + 1; j < s.length; j++) {
				if (s[i].equals(s[j])) {
					return true;
				}
			}
		}
		return false;
	}

	public void transAbhang() { // Transitivität erkennen und Regeln ergänzen
		String[][] neu = new String[0][0];
		for (int i = 0; i < abhang.length; i++) {
			for (int j = 0; j < abhang.length; j++) {
				if (abhang[i][1].equals(abhang[j][0])) {
					String[][] temp = new String[neu.length + 1][2];
					for (int s = 0; s < neu.length; s++) {
						temp[s] = neu[s];
					}

					temp[temp.length - 1] = new String[] { abhang[i][0], abhang[j][1] };
					neu = temp;
				}
			}

		}

		String[][] temp2 = new String[abhang.length + neu.length][2];
		for (int x = 0; x < abhang.length; x++) {
			temp2[x] = abhang[x];
		}
		for (int y = abhang.length; y < temp2.length; y++) {
			temp2[y] = neu[y - abhang.length];
		}
		transRegeln = temp2;
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
