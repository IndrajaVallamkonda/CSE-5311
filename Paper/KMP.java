public class KMP{
	void search(String pattern, String text){
		int M = pattern.length();
		int N = text.length();
		int lps[] = new int[M];
		int j = 0;
		computeLPSArray(pattern, M, lps);
		int i = 0;
		while ((N - i) >= (M - j)) {
			if (pattern.charAt(j) == text.charAt(i)) {
				j++;
				i++;
			}
			if (j == M) {
				System.out.println("Found pattern at index " + (i - j));
				j = lps[j - 1];
			}
			else if (i < N && pattern.charAt(j) != text.charAt(i)) {
				if (j != 0)
					j = lps[j - 1];
				else
					i = i + 1;
			}
		}
	}
	void computeLPSArray(String pattern, int M, int lps[]){
		int len = 0;
		int i = 1;
		lps[0] = 0; 
		while (i < M) {
			if (pattern.charAt(i) == pattern.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			}
			else {
				if (len != 0) {
					len = lps[len - 1];
				}
				else {
					lps[i] = len;
					i++;
				}
			}
		}
	}
	public static void main(String args[]){
		String text = "hello this is a test string to say hello and to pattern match word hello";
		String pattern = "hello";
		new KMP().search(pattern, text);
	}
}
