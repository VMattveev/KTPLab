import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Crawler {
	public static void main(String[] args)  {
		String url = args[0];
		int maxDepth = Integer.parseInt(args[1]);
		int threadsAmount = Integer.parseInt(args[2]);

		URLPool pool = new URLPool(new URLDepthPair(url, 0), maxDepth);

		for (int i = 0; i < threadsAmount; i++) {
			CrawlerTask task = new CrawlerTask(pool, threadsAmount);
			Thread thread = new Thread(task);
			thread.start();
		}

		pool.printVisited();
	}

	public static LinkedList<URLDepthPair> getSites(URLDepthPair pair) {
		LinkedList<URLDepthPair> links = new LinkedList<>();
		try {
			URL url = new URL(pair.getUrl());

			Scanner scanner = new Scanner(url.openStream());

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				parseLine(links, line, pair.getDepth());
			}
		} catch (IOException e) {
			System.out.println("Cannot connect: " + pair.getUrl());
		}

		return links;
	}

	public static void parseLine(LinkedList<URLDepthPair> links, String line, int depth) {
		if (line.contains("<a")) {
			line = line.substring(line.indexOf("<a"));
			if (line.contains("href=")) {
				line = line.substring(line.indexOf("href="));

				try {
					line = line.substring(line.indexOf(URLDepthPair.URL_PREFIX));
					String suburl = line.substring(0, line.indexOf("\""));
					links.add(new URLDepthPair(suburl, depth + 1));
					line = line.substring(suburl.length());
					parseLine(links, line, depth);
				} catch (StringIndexOutOfBoundsException ignored) {	}
			}
		}
	}
}
