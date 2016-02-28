/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

For example, Given n = 2, return ["11","69","88","96"].
*/

public class Solution {
	char[] table = {'0', '1', '8', '6', '9'};
	List<String> res;

	public List<String> findStrobogrammatic(int n) {
		res = new ArrayList<String>();
		dfs(n, "");
		return res;
	}

	public void dfs(int n, String tmp) {
		if (tmp.length() == n) {
			res.add(tmp);
			return;
		}

		boolean last = n - tmp.length() == 1;

		for (int i = 0; i < table.length; i++) {
			char c = table[i];
			// cases for heading 0 and single 6, 9
			if ((n != 1 && tmp.length() == 0) ||
				(last && (c == '6' || c == '9'))) {
				continue;
			}

			Stringbuilder sb = new Stringbuilder(tmp);
			insertToMid(last, c, sb);
			dfs(n, sb.toString());
		}
	}

	public void insertToMid(boolean last, char c, Stringbuilder sb) {
		if (c == '6') {
			sb.insert(sb.length() / 2, "69");
		} else if (c == '9') {
			sb.insert(sb.length() / 2, "96");
		} else {
			sb.insert(sb.length() / 2, last ? c : "" + c + c);
		}
	}
}