/*
Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), 
where largest means subtree with largest number of nodes in it.

Note:
A subtree must include all of its descendants.
Here's an example:

    10
    / \
   5  15
  / \   \ 
 1   8   7
The Largest BST Subtree in this case is the highlighted one. 
The return value is the subtree's size, which is 3.

Follow up:
Can you figure out ways to solve it with O(n) time complexity?
*/

class SubTree {
	boolean isBST;
	int min;
	int max;
	int res;
	public SubTree() {
		isBST = false;
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		res = 0;
	}
}

public class Solution {
	public int largestBSTsubtree(TreeNode root) {
		return dfs(root).res;
	}

	public SubTree dfs(TreeNode root) {
		if (root = null) {
			return new SubTree();
		}

		SubTree cur = new SubTree();
		SubTree leftTree = dfs(root.left);
		SubTree rightTree = dfs(root.right);

		cur.min = Math.min(root.val, leftTree.min);
		cur.max = Math.max(root.val, rightTree.max);

		if (leftTree.isBST && rightTree.isBST && root.val >= leftTree.max && root.val <= rightTree.min) {
			cur.isBST = true;
			cur.res = leftTree.res + rightTree.res + 1;
		} else {
			cur.isBST = false;
			cur.res = Math.max(leftTree.res, rightTree.res);
		}

		return cur;
	}
}