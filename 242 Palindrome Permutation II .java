/*

Given a string s, return all the palindromic permutations (without duplicates) of it. 
Return an empty list if no palindromic permutation could be form.

For example:

Given s = "aabb", return ["abba", "baab"].

Given s = "abc", return [].

Hint:

If a palindromic permutation exists, we just need to generate the first half of the string.
To generate all distinct permutations of a (half of) string, use a similar approach from: 
Permutations II or Next Permutation.

*/

public class Solution {
	public List<String> generate(String s) {
		List<String> res = new ArrayList<>();
		HashMap<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			map.putIfAbsent(c, 0);
			map.put(c, map.get(c) + 1);
		}

		String candidates = "";
		String odd = "";
		boolean hasOne = false;

		for (Character c : map.keySet()) {
			int num = map.get(c) / 2;
			for (int i = 0; i < num; i++) {
				candidates += c;
			}

			if (map.get(c) % 2 != 0) {
				if (hasOne) {
					return res;
				} else {
					single += c;
					hasOne = true;
				}
			}
		}

		if (candidates.length() == 0 && single.length() != 0) {
			res.add(single);
			return res;
		}

		helper("", candidates, single, candidates.length(), res);
		return res;
	}

	public void helper(String left, String candidates, String single, int len, List<String> res) {
		if (left.length() == len) {
			res.add(left + single + new StringBuilder(left).reverse().toString());
		}

		for (int i = 0; i < candidates.length(); i++) {
			if (i > 0 && candidates.charAt(i) == candidates.charAt(i - 1)) {
				continue;
			}
			//important
			helper(left + candidates.charAt(i), candidates.substring(0, i) + candidates.substring(i + 1),
				   single, len, res);
		}
	}
}