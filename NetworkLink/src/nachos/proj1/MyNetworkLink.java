package nachos.proj1;

import nachos.machine.Machine;
import nachos.machine.MalformedPacketException;
import nachos.machine.NetworkLink;
import nachos.machine.Packet;
import nachos.threads.Semaphore;

public class MyNetworkLink {
	Semaphore semaphore = new Semaphore(0);
	NetworkLink networkLink = Machine.networkLink();
	
	public MyNetworkLink() {
		networkLink.setInterruptHandlers(
		new Runnable() {	
			@Override
			public void run() {
				Packet receivePacket = networkLink.receive();
				System.out.println("\n\nYou have new message "+  new String(receivePacket.contents));
			}
		}, new Runnable() {
			@Override
			public void run() {
			}
		});
	}
	
	
	public void send(String message, int destinationLink) {
		try {
			Packet packet = new Packet(destinationLink, getAddress(), message.getBytes());
			networkLink.send(packet);
			
			semaphore.P();
		} catch (MalformedPacketException e) {
			System.out.println("Send message failed");
		}
	}
	
	public int getAddress() {
		return networkLink.getLinkAddress();
	}
}
