package ui;

import java.util.Scanner;

import model.Counting;
import thread.CountingThread;

public class InteractiveMain {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Until what number should I count?: ");
		int maxNum = Integer.parseInt(sc.nextLine());
		System.out.print("What will be the duration of each count in millis?: ");
		long sleepMillis = Long.parseLong(sc.nextLine());
		System.out.print("How many threads do you want to use to count?: ");
		int amountThreads = Integer.parseInt(sc.nextLine());
		
		sc.close();
		
		CountingThread[] threads = new CountingThread[amountThreads];
		int intervals = maxNum/threads.length;
		
		for (int i = 0; i < threads.length; i++) {
			System.out.println(i*intervals+" "+(i+1)*intervals);
			Counting c = new Counting(i*intervals, (i+1)*intervals);
			threads[i] = new CountingThread(c, sleepMillis);
		}
		
		long init = System.currentTimeMillis();
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		
		for (int i = 0; i < threads.length; i++) {
			threads[i].join();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("Duration with "+amountThreads+" threads: "+(end-init));
	}

}
