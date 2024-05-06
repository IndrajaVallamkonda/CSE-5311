public class RabinKarp {
	public final static int d = 256;
	static void search(String pattern, String text, int primeNumber){
		int M = pattern.length();
		int N = text.length();
		int p = 0;
		int t = 0; 
		int h = 1;
		for (int i = 0; i < M - 1; i++)
			h = (h * d) % primeNumber;
		for (int i = 0; i < M; i++) {
			p = (d * p + pattern.charAt(i)) % primeNumber;
			t = (d * t + text.charAt(i)) % primeNumber;
		}
		for (int i = 0, j; i <= N - M; i++) {
			if (p == t) {
				for (j = 0; j < M; j++) {
					if (text.charAt(i + j) != pattern.charAt(j))
						break;
				}
				if (j == M){
					System.out.println("Pattern found at index " + i);
				}
			}
			if (i < N - M) {
				t = (d * (t - text.charAt(i) * h) + text.charAt(i + M)) % primeNumber;
				if (t < 0)
					t = (t + primeNumber);
			}
		}
	}
	public static void main(String[] args)
	{
		String text = "hello this is a test string to say hello and to pattern match word hello";
		String pattern = "hello";
		search(pattern, text, 101);
	}
}
