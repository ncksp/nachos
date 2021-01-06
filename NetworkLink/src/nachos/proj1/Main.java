package nachos.proj1;

import java.util.Scanner;

public class Main {
	private MyNetworkLink mnl = new MyNetworkLink();
	private MyConsole console = new MyConsole();
	public Main() {
		
		do {
			console.writeln("My Address = " + mnl.getAddress());
			console.write("Input destination: ");
			int dstLink = console.readInt();
			
			console.write("Input message: ");
			String msg = console.read();
			
			mnl.send(msg, dstLink);
		}while(true);
	}

}
