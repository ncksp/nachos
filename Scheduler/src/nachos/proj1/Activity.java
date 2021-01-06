package nachos.proj1;

public class Activity implements Runnable {
	private String name;
	private int duration;

	public Activity(String name, int duration) {
		this.name = name;
		this.duration = duration;
	}

	@Override
	public void run() {
		while (duration > 0) {
			System.out.println(name + " has started and will finish in " + duration--);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}

		System.out.println(name + " is finished");
	}

}
