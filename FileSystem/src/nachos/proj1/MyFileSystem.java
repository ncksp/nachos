package nachos.proj1;

import java.util.Arrays;
import java.util.Vector;

import nachos.machine.FileSystem;
import nachos.machine.Machine;
import nachos.machine.OpenFile;

public class MyFileSystem {
	
	private FileSystem fs = Machine.stubFileSystem();
	
	public void writeFile(String filename, Vector<String> names) {
		OpenFile out = fs.open(filename, true);
		
		for (String name : names) {
			name = name + "\n";
			
			byte[] data = name.getBytes();
			
			out.write(data, 0, data.length);
		}
		
		out.close();
	}

	public Vector<String> readFile(String filename){
		OpenFile in = fs.open(filename, false);
		Vector<String> values = new Vector<String>();
		
		if(in == null) {
			System.out.println("File not found");
			return values;
		}
		
		byte[] lines = new byte[99999];
		
		in.read(lines, 0, 99999);
		
		String data = new String(lines).trim();
		
		String[] temp = data.split(" ");
		
		values.addAll(Arrays.asList(temp));
		
		in.close();
		
		return values;
	}
	 
	public String removeFile(String filename) {
		boolean isDeleted = fs.remove(filename);
		
		if(isDeleted) return "File deleted";
		
		return "File not found";
	}
}
