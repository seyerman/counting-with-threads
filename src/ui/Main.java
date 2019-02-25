package ui;

import hilo.CountingThread;
import model.Counting;

public class Main {

	public static void main(String[] args) {
		long init = System.currentTimeMillis();
		
		
		Counting c1 = new Counting(0, 20);
		Counting c2 = new Counting(21, 40);
		Counting c3 = new Counting(41, 60);
		Counting c4 = new Counting(61, 80);
		Counting c5 = new Counting(81, 100);
		//c.count();
		
		CountingThread ct1 = new CountingThread(c1);
		CountingThread ct2 = new CountingThread(c2);
		CountingThread ct3 = new CountingThread(c3);
		CountingThread ct4 = new CountingThread(c4);
		CountingThread ct5 = new CountingThread(c5);
		ct1.start();
		ct2.start();
		ct3.start();
		ct4.start();
		ct5.start();
		long end = System.currentTimeMillis();
		
		System.out.println("Duration: "+(end-init));
	}

}
