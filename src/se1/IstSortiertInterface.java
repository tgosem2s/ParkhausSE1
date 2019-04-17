package se1;

public interface IstSortiertInterface {
	public void setAbhang(String[][] c); // public is implicit in interfaces
	public String[][] getAbhang();
	public boolean abhaengigkeit(String a, String b, String[][] c);
	public boolean isWellSorted(String[] sequence);
}
