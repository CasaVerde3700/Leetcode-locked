/*
Given a string, find the length of the longest substring T that contains at most k distinct characters.

For example, Given s = “eceba”, k = 2

T is "ece" which its length is 3.
*/

public int lenTwoDistinct(String s, int k) {
	int max = 0;
	int start = 0;
	Map<Character, Integer> map = new HashMap<>();

	for (int i = 0; i < s.length(); i++) {
		char c = s.charAt(i);
		if (map.size() >= k && !map.containsKey(c)) {
			int leftMost = s.length();
			max = Math.max(max, i - start);
			for (Character key : map.keySet()) {
				leftMost = Math.min(leftMost, map.get(key));
			}
			start = leftMost + 1;
			map.remove(s.charAt(leftMost));
		}
		map.put(c, i);
	}

	max = Math.max(max, s.length - start);
	return max;
}