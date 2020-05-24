package in.schedule;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class SchedulerService {

	public static void main(String[] args) {
		Set<String> data = new HashSet<>();
		data.add("one");
		data.add("two");
		data.add("three");

		while (true) {
			try {
				System.out.println("Started in run");
				java.util.Properties p = new java.util.Properties();
				p.load(new FileInputStream("c:\\temp\\tasks.txt"));
				for (String key : data) {
					Object value = p.getProperty(key);
					if (value == null) {
						SchedulerThreadFactory.getInstance().stop(key);
					} else {
						SchedulerThreadFactory.getInstance().start(key, Long.parseLong(value.toString()));
					}
				}
				System.out.println(SchedulerThreadFactory.getInstance().printActiveTaks());
				 Thread.sleep(60000);
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
