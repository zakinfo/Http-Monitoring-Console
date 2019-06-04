package org.sid.app;
/**
* The Console program implements an application that
* monitors HTTP traffic
*
* @author  Zakaria REDJOUANI
* @version 1.0
* @since   2019-06-04
*/

import java.util.Timer;

import org.sid.beans.Alert;
import org.sid.beans.ReadLog;

public class Console {

	public static void main(String[] args) {
		/* Display sections each 10 seconds */
		Timer timer = new Timer();
		timer.schedule(new ReadLog(), 0, 10000);

		/* Check high traffic each 2 minuets */
		Timer timerAlert = new Timer();
		timerAlert.schedule(new Alert(), 0, 120000);

	}

}
