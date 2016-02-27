/*
Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

For example:
Given binary tree,
              5
             / \
            1   5
           / \   \
          5   5   5
return 4.
*/

public class Solution {
	int count = 0;

	public int countUniSub(TreeNode root) {
		isUniSub(root);
		return count;
	}

	public boolean isUniSub(TreeNode root) {
		if (root == null) {
			return true;
		}

		if (root.left == null && root.right == null) {
			return true;
		}

		boolean left = isUniSub(root.left);
		boolean right = isUniSub(root.right);

		if (left && right &&
			(root.left == null || root.left.val == root.val) &&
			(root.right == null || root.right.val == root.val)) {
			count++;
			return true;
		}

		return false;
	}
}