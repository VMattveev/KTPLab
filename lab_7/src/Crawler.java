import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Crawler {
	public static void main(String[] args) {
		LinkedList<URLDepthPair> visited = new LinkedList<>();
		LinkedList<URLDepthPair> urls = new LinkedList<>();
		LinkedList<URLDepthPair> finded = new LinkedList<>();
		int maxDepth = Integer.parseInt(args[1]);

		urls.add(new URLDepthPair(args[0], 0));


		while (!urls.isEmpty()) {
			for (URLDepthPair pair : urls) {
				if (!visited.contains(pair) && pair.getDepth() <= maxDepth) {
					System.out.println(pair);
					finded.addAll(Crawler.getSites(pair));
					visited.add(pair);
				}
			}

			urls.clear();
			urls.addAll(finded);
			finded.clear();
		}
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
