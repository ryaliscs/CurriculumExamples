package in.schedule;

import java.util.HashMap;
import java.util.Map;

public class SchdulerTaskFactory {

	private static final Map<String, Class<? extends Runnable>> SCHEDULE_TASKS = new HashMap<>(2);

	static {
		SCHEDULE_TASKS.put("two", PrintNumberScheduler.class);
		SCHEDULE_TASKS.put("one", PrintCharScheduler.class);
	}

	private SchdulerTaskFactory() {
	}

	public static Class<? extends Runnable> getSchdulerTask(String aTaskName) {
		return SCHEDULE_TASKS.get(aTaskName);
	}
}
