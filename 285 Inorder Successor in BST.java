// 如果右节点为空，回溯父节点找第一个比目标节点大的节点，如果存在，一定会在path中

public class Solution {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode node) {
		Stack<TreeNode> st = new Stack<>();
		TreeNode cur = root;

		// path
		while (cur != node) {
			st.push(cur);
			if (cur.val > node.val) {
				cur = cur.left;
			} else {
				cur = cur.right;
			}
		}

		// found
		if (cur.right != null) {
			cur = cur.right;
			while (cur.left != null) {
				cur = cur.left;
			}
			return cur;
		} else {
			while (!st.isEmpty() && st.peek().val < cur.val) {
				st.pop();
			}
			return st.isEmpty() ? null : st.peek();
		}
	}
}