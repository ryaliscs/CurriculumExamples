package in.schedule;

public class PrintNumberScheduler implements Runnable {

	@Override public void run() {
		System.out.println(getClass().getSimpleName() + " Started");
		for (int i = 1; i < 5; i++) {
			System.out.println(getClass().getSimpleName()+":-"+i);
		}
		System.out.println(getClass().getSimpleName() + " Finished");
	}
}