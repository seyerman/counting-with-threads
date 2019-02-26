package ui;

import model.Counting;
import thread.CountingThread;

public class OneThreadMain {

	public static void main(String[] args) throws InterruptedException {

		
		Counting c = new Counting(0, 20);
		
		CountingThread ct = new CountingThread(c, 100);		
		
		long init = System.currentTimeMillis();
		
		ct.start();
		
		ct.join();
		
		long end = System.currentTimeMillis();
		
		System.out.println("Duration with 1 thread: "+(end-init));
	}

}
