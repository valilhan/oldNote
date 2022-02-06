import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String S[] = br.readLine().trim().split(" ");
			int n = Integer.parseInt(S[0]);
			int m = Integer.parseInt(S[1]);
			String L[] = br.readLine().trim().split(" ");
			String R[] = br.readLine().trim().split(" ");
			HashMap<String, Boolean> hm = new HashMap<String, Boolean>();
			HashMap<String, Boolean> rm = new HashMap<String, Boolean>();
			for (int i = 0; i < n; i++) {
				if (hm.get(L[i]) == null) {
					hm.put(L[i], true);
				}
			}
			for (int i = 0; i < m; i++) {
				if (rm.get(R[i]) == null) {
					rm.put(R[i], true);
				}
			}
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < n; i++) {
				if (rm.get(L[i]) == null) {
					sb.append(L[i] + " ");
				}
			}
			System.out.println(sb.toString().trim());
		}
	}
}
