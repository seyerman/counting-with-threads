package ui;

import model.Counting;
import thread.CountingThread;

public class FiveThreadsMain {

	public static void main(String[] args) throws InterruptedException {

		
		Counting c1 = new Counting(0, 20);
		Counting c2 = new Counting(20, 40);
		Counting c3 = new Counting(40, 60);
		Counting c4 = new Counting(60, 80);
		Counting c5 = new Counting(80, 100);
		
		CountingThread ct1 = new CountingThread(c1, 100);		
		CountingThread ct2 = new CountingThread(c2, 100);
		CountingThread ct3 = new CountingThread(c3, 100);
		CountingThread ct4 = new CountingThread(c4, 100);
		CountingThread ct5 = new CountingThread(c5, 100);
		
		long init = System.currentTimeMillis();
		
		ct1.start();
		ct2.start();
		ct3.start();
		ct4.start();
		ct5.start();
		
		ct1.join();
		ct2.join();
		ct3.join();
		ct4.join();
		ct5.join();
		
		long end = System.currentTimeMillis();
		
		System.out.println("Duration with 5 threads: "+(end-init));
	}

}
