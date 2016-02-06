/**
 * Verify Preorder Sequence in Binary Search Tree 
 *
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
 * You may assume each number in the sequence is unique.
 * Follow up: Could you do it using only constant space complexity?
 */

class Solution {
	// O(n) space
	public boolean isPreOrder1 (int[] nums) {
		Stack<Integer> st = new Stack<>();
		int min = Integer.MIN_VALUE;
		
		for (int val : nums) {
			if (val < min) return false;
			
			while (!st.isEmpty() && val > st.peek()) {
				min = st.pop();
			}
			st.push(val);
		}	
		return true;
	}
	
	// constant space
	public boolean isPreOrder2 (int[] nums) {
		int i = -1, min = Integer.MIN_VALUE;
		
		for (int val : nums) {
			if (val < min) return false;
			
			while ( i >= 0 && val > nums[i]) {
				min = nums[i--];
			}
			nums[++i] = val;
		}		
		return true;
	}
}