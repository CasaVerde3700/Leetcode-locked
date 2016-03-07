/*
Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in 
the tree along the parent-child connections. The longest consecutive path need to 
be from parent to child (cannot be the reverse).

For example,

   1
    \
     3
    / \
   2   4
        \
         5 
Longest consecutive sequence path is 3-4-5, so return 3.

   2
    \
     3
    / 
   2    
  / 
 1 
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
*/

public class Solution {
	public int longestLen(TreeNode root) {
		retrun findLongest(root, 0, root.val - 1);
	}

	public int findLongest(TreeNode root, int length, int preVal) {
		if (root == null) {
			return length;
		}

		int curLen = preVal + 1 == root.val ? length + 1 : 1;

		return Math.max(Math.max(curLen, findLongest(root.left, curLen, root.val)),
						findLongest(root.right, curLen, root.val));
	}
}
