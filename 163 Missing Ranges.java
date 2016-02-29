/*
Given a sorted integer array where the range of elements 
are [lower, upper] inclusive, return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, 
return ["2", "4->49", "51->74", "76->99"].
*/

public class Solution {
	public List<String> findRanges(int[] nums, int lower, int upper) {
		List<String> res = new ArrayList<>();
		int pre = lower - 1, cur =  0;
		for (int i = 0; i <= nums.length; i++) {
			cur = i == nums.length ? upper + 1 : nums[i];
			if (cur - pre > 1) {
				res.add(getRange(pre + 1, cur - 1));
			}
			pre = cur;
		}
		return res;
	}

	public String getRange(int a, int b) {
		return a == b ? String.valueOf(a) : a + "->" + b;
	}
}