package thread;

import model.Counting;

public class CountingThread extends Thread{
	private Counting counting;
	private long sleepMillis;
	public CountingThread(Counting co, long sm) {
		counting = co;
		sleepMillis = sm;
	}
	
	@Override
	public void run() {
		try {
			while(counting.getCurrentNumber()<counting.getEndNumber()) {
				counting.count();
				System.out.println(counting.getCurrentNumber());
				Thread.sleep(sleepMillis);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
