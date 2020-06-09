public class CrawlerTask implements Runnable {
	private final URLPool pool;
	private final int threadsAmount;

	public CrawlerTask(URLPool pool, int threadsAmount) {
		this.pool = pool;
		this.threadsAmount = threadsAmount;
	}

	@Override
	public void run() {
//		System.out.println(Thread.currentThread().getName() + ": Thread runned");

		while (pool.getWaitingAmount() < threadsAmount) {
			URLDepthPair pair = pool.first();
//			System.out.println(Thread.currentThread().getName() + ": " + pair);

			if (pair != null) {
				for (URLDepthPair urlPair : Crawler.getSites(pair)) {
					pool.add(urlPair);
				}
			} else {
				try {
					synchronized (pool) {
						pool.incWaitingAmount();
						System.out.println(pool.getWaitingAmount());
						if (pool.getWaitingAmount() == threadsAmount) {
							pool.notifyAll();
						} else {
//							System.out.println(Thread.currentThread().getName() + ": in waiting");
							pool.wait();
//							System.out.println(Thread.currentThread().getName() + ": wake up");
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
