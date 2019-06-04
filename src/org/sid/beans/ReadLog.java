package org.sid.beans;

/**
* Consume an actively written-to w3c-formatted HTTP access log
*
* @author  Zakaria REDJOUANI
* @version 1.0
* @since   2019-06-04
*/
import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TimerTask;

public class ReadLog extends TimerTask {

	private List<String> sections = new ArrayList<String>();
	private int sizeListe;

	@Override
	public void run() {
		try {

			Scanner s = new Scanner(new File("../Http Monitoring/src/data/log.txt"));
			while (s.hasNext()) {
				String section = getSection(s.next());
				if (section.contains("http") && !sections.contains(section))
					sections.add(section);
			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		sizeListe = sections.size();
		for (int i = 0; i < sizeListe; i++)
			System.out.println("section : " + sections.get(i));

	}

	public String getSection(String line) {

		if (line.contains("http://")) {
			String parts[] = line.split("http://");
			if (parts[1].contains("/")) {
				String lists[] = parts[1].split("/");
				if (lists.length >= 2) {
					return "http://" + lists[0] + "/" + lists[1];
				} else {
					return "http://" + lists[0];
				}

			} else {
				return "";
			}

		} else {
			return "";
		}

	}

	public int getSizeListe() {
		return sizeListe;
	}

}
