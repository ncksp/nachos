package nachos.proj1;

import nachos.machine.Machine;
import nachos.machine.Timer;

public class Main {

	int number = 0;
	public Main() {
		System.out.println("Hello World");
		System.out.println("Console");
		
		//Serial Console
		MyConsole console = new MyConsole();
//		
//		String str = console.read();
//		
//		console.writeln(str);
//		
//		int number = console.readInt();
//		
//		console.write(""+number);
		
		
		//Timer
		Timer timer = Machine.timer();
		timer.setInterruptHandler(new Runnable() {
			@Override
			public void run() {
				number++;
			}
		});
		
		console.read(); //using read to stop timer
	}

}
