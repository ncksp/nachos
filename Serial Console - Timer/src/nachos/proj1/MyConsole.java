package nachos.proj1;

import nachos.machine.Machine;
import nachos.machine.SerialConsole;
import nachos.threads.Semaphore;

public class MyConsole {

	private SerialConsole serialConsole = Machine.console();
	private char temp;
	private Semaphore semaphore = new Semaphore(0);
	
;	public MyConsole() {
		
		Runnable receiveInterruptHandler = new Runnable() {
			
			@Override
			public void run() {
				temp = (char) serialConsole.readByte();
				semaphore.V();
			}
		};
		
		Runnable sendInterruptHandler = new Runnable() {
			
			@Override
			public void run() {
				semaphore.V();
			}
		};
		
		serialConsole.setInterruptHandlers(receiveInterruptHandler, sendInterruptHandler);
	}
	
	public String read() {
		StringBuilder s = new StringBuilder(); //use string builder to avoid staging String Object
		
		do {
			semaphore.P();
			if(temp == '\n') break;
			
			s.append(temp);
		}while(true);
		
		return s.toString();
	}
	
	public int readInt() {
		int value = -1;
		try {			
			value = Integer.parseInt(read());
		} catch (Exception e) {
		}
		return value;
	}
	
	public void write(String s) {
		for (int i = 0; i < s.length(); i++) {
			serialConsole.writeByte(s.charAt(i));
			semaphore.P();
		}
	}
	
	public void writeln(String s) {
		write(s + "\n");
	}

}
