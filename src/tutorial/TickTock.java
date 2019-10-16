package tutorial;

public class TickTock {
	
	String state;
	
	synchronized void tick(boolean running) {
		if(!running) {
			state = "ticked";
			notify();
			return;
		}
		
		System.out.print("Tick ");
		
		state = "ticked";
		
		notify();
		try {
			while(!state.equals("tocked"))
				wait();
		} catch (InterruptedException e) {
			System.out.println("thread interrupted");
		}
	}
	
	synchronized void tock(boolean running) {
		if(!running) {
			state = "tocked";
			notify();
			return;
		}
		
		System.out.print("Tock ");
		
		state = "tocked";
		
		notify();
		try {
			while(!state.equals("ticked"))
				wait();
		} catch (InterruptedException e) {
			System.out.println("thread interrupted");
		}
	}
			
}
