import java.util.*;
import java.io.*;

class cmp implements Comparator<Map.Entry<Integer, Integer>> {
	@Override
	public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
		return o1.getKey() - o2.getKey();
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String S[] = br.readLine().trim().split(" ");
			HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
			for (int i = 0; i < S.length; i++) {
				int value = Integer.parseInt(S[i]);
				if (mp.get(value) == null) {
					mp.put(value, 1);
				} else {
					int c = mp.get(value);
					mp.put(value, ++c);
				}
			}
			// all element in the map
			Set<Map.Entry<Integer, Integer>> ss = mp.entrySet();
			ArrayList<Map.Entry<Integer, Integer>> arr = new ArrayList<Map.Entry<Integer, Integer>>(ss);
			Collections.sort(arr, new cmp());
			Iterator<Map.Entry<Integer, Integer>> index = arr.iterator();
			StringBuffer ans = new StringBuffer();
			System.out.println(arr);
			while (index.hasNext()) {
				Map.Entry<Integer, Integer> val = index.next();
				int inner = val.getValue();
				while (inner > 0) {
					ans.append(val.getKey() + " ");
					inner--;
				}
			}
			System.out.println(ans.toString().trim());
		}
	}
}
