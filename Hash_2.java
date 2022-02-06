import java.util.*;
import java.io.*;

public class Hash_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			String S[] = br.readLine().trim().split(" ");
			Set<Integer> ss = new HashSet<Integer>();
			int[] A = new int[n];
			for (int i = 0; i < n; i++) {
				int v = Integer.parseInt(S[i]);
				ss.add(v);
				A[i] = v;
			}
			String ANS[] = new String[n];
			int max = Integer.MIN_VALUE;
			int id = -1;
			for (int i = 0; i < n; i++) {
				if (!ss.contains((A[i] - 1))) {// if such element don't exit, so A[i] first element
					int v = A[i];
					String ans = "" + v;
					int max_in = 0;
					while (ss.contains(v + 1)) {
						v++;
						ans += " " + v;
						max_in++;
					}
					if (max_in > max) {
						id = i;
						max = max_in;
					}
					ANS[i] = ans;
				}
			}
			System.out.println(ANS[id]);
		}
	}
}
