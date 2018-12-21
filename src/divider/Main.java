package divider;

public class Main {
	public static void main(String[] args) {
		
		final String path1 = "src/data/100.xml";
		final String path2 = "src/data/200.xml";
		final String path3 = "src/data/300.xml";
		
		Divider d = new Divider();
		d.divide(path1, "WT01");
		d.divide(path2, "WT02");
		d.divide(path3, "WT03");
	}
}
