package in.schedule;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class SchedulerThreadFactory {

	private static final SchedulerThreadFactory stf = new SchedulerThreadFactory();
	private final ScheduledExecutorService ses;

	private Map<String, SchedulerPojo> tasks = new HashMap<>(2);

	private SchedulerThreadFactory() {
		ses = Executors.newScheduledThreadPool(2);
	}

	public static SchedulerThreadFactory getInstance() {
		return stf;
	}

	public void start(String aSchedulerName, long aFrequency) {
		SchedulerPojo schedulerPojo = this.tasks.get(aSchedulerName);
		if (schedulerPojo == null) {
			createSchedulerTask(aSchedulerName, aFrequency);
		} else if (schedulerPojo.getFrequency() != aFrequency) {
			stop(aSchedulerName);
			createSchedulerTask(aSchedulerName, aFrequency);
		}
	}

	public void update(String aSchedulerName, long aFrequency) {
		start(aSchedulerName, aFrequency);
	}

	public void stop(String aSchedulerName) {
		SchedulerPojo sp = this.tasks.remove(aSchedulerName);
		if (sp != null)
			sp.getSchedulerFuture().cancel(false);
	}

	public String printActiveTaks() {
		StringBuilder activeTasks = new StringBuilder();
		for (String task : tasks.keySet()) {
			activeTasks.append(task).append("\n");
		}
		return activeTasks.toString();
	}

	private void createSchedulerTask(String aSchedulerName, long aFrequency) {
		Class<? extends Runnable> schedulerTask = SchdulerTaskFactory.getSchdulerTask(aSchedulerName);
		if (schedulerTask != null) {
			try {
				ScheduledFuture<?> f1 = ses.scheduleWithFixedDelay(schedulerTask.newInstance(), //
						0, aFrequency, TimeUnit.SECONDS);
				SchedulerPojo sp = new SchedulerPojo(aSchedulerName, aFrequency, f1);
				this.tasks.put(aSchedulerName, sp);

			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}

	}

}
