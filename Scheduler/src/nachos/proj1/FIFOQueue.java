package nachos.proj1;

import java.util.Vector;

import nachos.threads.KThread;
import nachos.threads.ThreadQueue;

public class FIFOQueue extends ThreadQueue{

	private Vector<KThread> threads = new Vector<>();
	public FIFOQueue() {
	}

	@Override
	public void waitForAccess(KThread thread) {
		threads.add(thread);
	}

	@Override
	public KThread nextThread() {
		if(threads.isEmpty()) return null;
		
		return threads.remove(0);
	}

	@Override
	public void acquire(KThread thread) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

}
