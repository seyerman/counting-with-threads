package hilo;

import model.Counting;

public class CountingThread extends Thread{
	private Counting counting;
	public CountingThread(Counting co) {
		counting = co;
	}
	
	@Override
	public void run() {
		try {
			while(counting.getCurrentNumber()<counting.getEndNumber()) {
				counting.count();
				System.out.println(counting.getCurrentNumber());
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
