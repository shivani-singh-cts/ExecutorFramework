package com.multithreading;

//By extending Thread Class
class Task1 extends Thread{
	public void run() {
		System.out.println("Task 1 Started");
		for(int i =101; i<199; i++)
			System.out.print(i + " ");
		System.out.println();
		System.out.println("Task 1 Completed");
	}
}
//By implementing Runnable interface
class Task2 implements Runnable {

	@Override
	public void run() {
		System.out.println("Task 2 Started");
		for(int i =201; i<299; i++)
			System.out.print(i + " ");
		System.out.println();
		System.out.println("Task 2 Completed");
	}
	
}
public class ThreadBasicsRunner {

	public static void main(String[] args) {
		//Task1
		Task1 task1 = new Task1();
		task1.start();

		//Task2
		Task2 task2 = new Task2();
		Thread t = new Thread(task2);
		t.start();
	}

}
