
public class URLDepthPair {
	public static final String URL_PREFIX = "https://";

	private String url;
	private int depth;

	public URLDepthPair(String url, int depth) {

		this.url = url;
		this.depth = depth;
	}

	public String getUrl() {
		return url;
	}

	public int getDepth() {
		return depth;
	}

	@Override
	public String toString() {
		return depth + " - " + url;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof URLDepthPair) {
			return url.equals(((URLDepthPair) obj).url);
		}
		return false;
	}
}
