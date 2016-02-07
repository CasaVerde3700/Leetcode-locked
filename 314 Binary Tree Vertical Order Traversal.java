public class Solution {
	// Two queues, bfs. Can't dfs
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		Queue<Integer> nodeQueue = new LinkedList<>();
		Queue<Integer> distQueue = new LinkedList<>();
		int min = 0, max = 0;

		nodeQueue.offer(root);
		distQueue.offer(0);
		map.put(0, new ArrayList<Integer>());
		map.get(0).add(root.val);

		while (!nodeQueue.isEmpty()) {
			TreeNode cur = nodeQueue.poll();
			int dist = distQueue.poll();

			if (root.left != null) {
				nodeQueue.offer(root.left);
				distQueue.offer(dist - 1);
				map.putIfAbsent(dist - 1, new ArrayList<Integer>());
				map.get(dist - 1).add(root.left.val);
				min = Math.min(dist - 1, max);
			}

			if (root.right != null) {
				nodeQueue.offer(root.right);
				distQueue.offer(dist + 1);
				map.putIfAbsent(dist + 1, new ArrayList<Integer>());
				map.get(dist + 1).add(root.right.val);
				max = Math.max(dist + 1, max);
			}
		}

		for (int i = min; i <= max; i++) {
			res.add(map.get(i));
		}
		
		return res;
	}
}