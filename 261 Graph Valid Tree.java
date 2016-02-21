/*
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Hint:
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree? 
Show More Hint Note: you can assume that no duplicate edges will appear in edges. Since all edges are 
undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Solution: Union Find
How to validate a tree:
1. Circle check
2. All connected

*/

public class Solution {
	public boolean validTree(int n, int[][] edges) {
		UnionFind uf = new UnionFind(n);
		for (int i = 0; i < edges.length; i++) {
			// union and check circle
			if (!uf.union(edges[i][0], edges[i][1])) {
				return false;
			}
		}
		// only one component
		return uf.cnt == 1;
	}

	public Class UnionFind {
		int[] ids;
		int cnt;

		public UnionFind(int n) {
			this.ids = new int[n];
			for (int i = 0; i < n; i++) {
				this.ids[i] = i;
			}
			this.cnt = n;
		}

		// boolean for cirlce check
		public boolean union(int a, int b) {
			int rootA = find(a);
			int rootB = find(b);
			// not in the same set
			if (rootA != rootB) {
				for (int i = 0; i < ids.length; i++) {
					if (ids[i] == rootA) {
						ids[i] = rootB;
					}
				}
				cnt--;
				return true;
			} else {
				return false;
			}
		}

		public int find(int x) {
			return ids[x];
		}
	}
}
