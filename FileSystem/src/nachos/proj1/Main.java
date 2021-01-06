package nachos.proj1;

import java.util.Vector;

public class Main {

	public Main() {
		System.out.println("Halo");
		
//		Write File		
		MyFileSystem mf = new MyFileSystem();
		
		Vector<String> names = new Vector<>();
		
		names.add("nicko");
		names.add("nicko1");
		names.add("nicko2");
		names.add("nicko3");
		mf.writeFile("names.txt", names);
		
		
//		Read File	
		Vector<String> reads = mf.readFile("names.txt");
		
		for (String string : reads) {
			System.out.println(string);
		}
		
		
//		Remove File
//		System.out.println(mf.removeFile("names.txt"));
	}

}
