package tutorial;

public class ThreadCom {

	public static void main(String[] args) {
		TickTock tt = new TickTock();
		MyThread mt1 = MyThread.createAndStart("Tick", tt);
		MyThread mt2 = MyThread.createAndStart("Tock", tt);
		
		try {
			mt1.thrd.join();
			mt2.thrd.join();
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted");
		}
	}

}
