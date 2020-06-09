import java.util.LinkedList;
import java.util.NoSuchElementException;

public class URLPool {
	private LinkedList<URLDepthPair> visited = new LinkedList<>();
	private LinkedList<URLDepthPair> planned = new LinkedList<>();
	private int maxDepth;
	private int waitingAmount = 0;

	URLPool(URLDepthPair pair, int maxDepth) {
		planned.add(pair);
		this.maxDepth = maxDepth;
	}

	public synchronized URLDepthPair first() {
		try {
			URLDepthPair pair = planned.removeFirst();
			visited.add(pair);
			return pair;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public synchronized void add(URLDepthPair pair) {
		if (!visited.contains(pair) && pair.getDepth() <= maxDepth) {
			this.notifyAll();
			waitingAmount = 0;
			planned.addLast(pair);
		} else {
			visited.addLast(pair);
		}
	}

	public synchronized boolean isEmpty() {
		return planned.isEmpty();
	}

	public synchronized void incWaitingAmount() {
		waitingAmount++;
	}

	public synchronized int getWaitingAmount() {
		return waitingAmount;
	}

	public void printVisited() {
		for (URLDepthPair pair : visited) {
			System.out.println(pair);
		}
	}
}
