/*
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to find the number of connected components in an undirected graph.

Example 1:
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

Note:
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, 
[0, 1] is the same as [1, 0] and thus will not appear together in edges.
*/

public class Solution {
	public int countComponents(int num, int[][] edges) {
		UnionFind uf = new UnionFind(num);
		for (int[] edge : edges) {
			if (!uf.isConnected(edge[0], edge[1])) {
				uf.union(edge[0], edge[1]);
			}
		}
		return uf.count;
	}
}


public class UnionFind{
	int[] ids;
	int count;

	public UnionFind(int num) {
		this.ids = new int[num];
		for (int i = 0; i < nums; i++) {
			ids[i] = i;
		}
		this.count = num;
	}

	public int find(int i) {
		return ids[i];
	}

	public void union(int idx1, int b) {
		int id1 = find(idx1);
		int id2 = find(idx2);
		if (id1 != id2) {
			for (int i = 0; i < ids.length; i++) {
				if (ids[i] == id2) {
					ids[i] = id1;
				}
			}
			count--;
		}
	}

	public boolean isConnected(int idx1, int idx2) {
		return ids[idx1] == ids[idx2];
	}
}