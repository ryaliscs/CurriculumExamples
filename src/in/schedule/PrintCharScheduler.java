package in.schedule;

public class PrintCharScheduler implements Runnable {

	@Override public void run() {
		System.out.println(getClass().getSimpleName() + " Begin");
		for (int i = 65; i < 70; i++) {
			System.out.println(getClass().getSimpleName()+":>"+(char) i);
		}
		System.out.println(getClass().getSimpleName() + " Completed");
	}
}