import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String s = br.readLine().trim();
			char A[] = s.toCharArray();
			HashSet<String> ss = new HashSet<String>();
			for (int i = 0; i < A.length; i++) {
				ss.add(A[i] + "");
			}
			int total = ss.size();
			HashMap<String, Integer> mp = new HashMap<String, Integer>();
			int tmp = 0;
			int min = Integer.MAX_VALUE;
			int start_indx = 0;
			for (int end = 0; end < A.length; end++) {
				if (mp.get(A[end] + "") == null) {
					mp.put(A[end] + "", 1);
					tmp++;
				} else {
					int c = mp.get(A[end] + "");
					mp.put(A[end] + "", ++c);
				}
				if (tmp == total) {
					for (int start = start_indx; start <= end; start++) {
						if (mp.get(A[start] + "") > 1) {
							int c = mp.get(A[start] + "");
							mp.put(A[start] + "", --c);
						} else {
							start_indx = start;
							min = Math.min(min, end - start + 1);
							break;
						}
					}
				}
			}
			System.out.println(min);
		}
	}
}
