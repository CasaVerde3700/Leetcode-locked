/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between 
 * a letter in pattern and a non-empty substring in str.
 *
 * Examples:
 * pattern = "abab", str = "redblueredblue" should return true.
 * pattern = "aaaa", str = "asdasdasdasd" should return true.
 * pattern = "aabb", str = "xyzabcxzyabc" should return false. 
 *
 * Notes:
 * You may assume both pattern and str contains only lowercase letters.
 */

public class solution {
	public boolean wordPatternMatch(String pattern, String word) {
		Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>(); // optional for duplicate matches

        return isMatch(word, 0, pattern, 0, map, set);
	}

	public boolean isMatch(String word, int i, String pattern, int j, Map<Character, String> map, Set<String> set) {
		if (i == word.length() && j == pattern.length()) return true;
		if (i == word.length() || j == pattern.length()) return false;

		char c = pattern.charAt(j);

		if (map.containsKey(c)) {
			String s = map.get(c);
			if (!word.startWith(s, i)) return falase;
			isMatch(word, i + s.length(), pattern, j + 1, map, set);
		}

		// backtracking
		for (int k = i; k < word.length(); k++) {
			String tmp = word.substring(i, k + 1);
			if (set.contains(tmp)) continue;
			map.put(c, tmp);
			set.add(tmp);
			if (isMatch(word, k + 1, pattern, j + 1, map, set)) return true;
			map.remove(c);
			set.remove(tmp);
		}

		return false;
	}
}

