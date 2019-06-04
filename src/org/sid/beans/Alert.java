package org.sid.beans;
/**
* Alert program is an application that
*check high traffic
*
* @author  Zakaria REDJOUANI
* @version 1.0
* @since   2019-06-04
*/

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

public class Alert extends TimerTask {
	private int counter = 10;

	ReadLog readLog = new ReadLog();

	int alert = readLog.getSizeListe();

	@Override
	public void run() {
		String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
		if (alert >= counter) {
			
			System.out
					.println("“High traffic generated an alert - hits = {" + alert + "}, triggered at {" + time + "}”");
		}else {
			System.out.println("the traffic has become stable at "+ time);
		}

	}

}
