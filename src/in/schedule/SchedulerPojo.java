package in.schedule;

import java.util.concurrent.ScheduledFuture;

public class SchedulerPojo {
	private final String name;
	private final long frequency;
	private final ScheduledFuture<?> schedulerFuture;

	SchedulerPojo(String aName, long aFreq, ScheduledFuture<?> aSF) {
		this.name = aName;
		this.frequency = aFreq;
		this.schedulerFuture = aSF;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the frequency
	 */
	public long getFrequency() {
		return frequency;
	}

	/**
	 * @return the schedulerFuture
	 */
	public ScheduledFuture<?> getSchedulerFuture() {
		return schedulerFuture;
	}

}
