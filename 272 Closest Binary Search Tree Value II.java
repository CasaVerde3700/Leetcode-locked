/*

Given a non-empty binary search tree and a target value, 
find k values in the BST that are closest to the target.

Note: Given target value is a floating point. You may assume 
k is always valid, that is: k ≤ total nodes. You are guaranteed 
to have only one unique set of k values in the BST that are 
closest to the target. 

Follow up: Assume that the BST is balanced, 
could you solve it in less than O(n) runtime (where n = total nodes)?
Hint: Consider implement these two helper functions: getPredecessor(N), 
which returns the next smaller node to N. getSuccessor(N), which 
returns the next larger node to N.

*/

// inorder with a k-sized queue. New elements compared with queue's head

public List<Integer> closestK(TreeNode root, double target, int k) {
	Queue<Integer> queue = new LinkedList<>();
	Stack<TreeNode> st = new Stack<>();
	while (root != null) {
		st.push(root);
		root = root.left;
	}
	while (!st.isEmpty()) {
		TreeNode cur = st.pop();
		if (queue.size() < k) {
			queue.offer(cur.val);
		} else {
			int first = queue.poll();
			if (Math.abs(first - target) > Math.abs(target - cur.val)) {
				queue.poll();
				queue.offer(cur.val);
			} else {
				break; // no need for right subtrees
			}
		}

		if (cur.right != null) {
			cur = cur.right;
			while (cur != null) {
				st.push(cur);
				cur = cur.left;
			}
		}
	}
	return (List<Integer>)queue;
}