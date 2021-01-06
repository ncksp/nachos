package nachos.proj1;

import java.util.Vector;

import nachos.threads.KThread;

public class Main {
	private MyConsole console = new MyConsole();
	private Vector<Activity> activities = new Vector<>();
	
	public Main() {
		System.out.println("Scheduler - KThread");
		
		int choice = -1;
		
		do {
			console.writeln("1. Add activity");
			console.writeln("2. Do Activities");
			console.write(">> ");
			
			choice = console.readInt();
			
			if(choice == -1)continue;		
			
			if(choice == 1) {
				console.write("Input name: ");
				String name = console.read();
				
				console.write("Input duration: ");
				int duration = console.readInt();
				
				activities.add(new Activity(name, duration));
				continue;
			}
			
			if(choice == 2) {
				while(!activities.isEmpty()) {
					new KThread(activities.remove(0)).fork();
				}
			}
		}while(true);
	}

}
