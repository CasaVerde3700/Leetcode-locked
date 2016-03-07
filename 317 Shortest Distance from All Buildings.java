/*
You want to build a house on an empty land which reaches all buildings in the shortest 
amount of distance. You can only move up, down, left and right. You are given a 2D grid of 
values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.
For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):
- 0 - 2 - 0 - 1
|   |   |   |   |
- 0 - 0 - 0 - 0
|   |   |   |   |
- 0 - 1 - 0 - 0
The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.

Note:
There will be at least one building. If it is not possible to build such house according to the above rules, return -1.

Solution: BFS
int[][] distance: the sum of shortest distance from every '0' to all reachable buildings
int[][] reach: how many building each '0' can be reached
Choose the shortest distances among all reach[i][j] == buildingNum.
Be careful the case where there are only buildings and no empty lands, like [[1]],
so shortest distance at last is still Integer.MAX_VALUE should be turned to -1
*/

public int shortestDist(int[][] grid) {
	int m = grid.length;
	int n = grid[0].length;
	int[][] dist = new int[m][n];
	int[][] reach = new int[m][n];
	int buildingNum = 0;
	int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			if (grid[i][j] == 1) {
				buildingNum++;
				Queue<Integer> queue = new LinkedList<>();
				queue.add(i * n + j);
				boolean[][] visited = new boolean[m][n]; // important
				visited[i][j] = true;
				int distance = 0;
				while (!queue.isEmpty()) {
					int size = queue.size();
					for (int k = 0; k < size; k++) {
						int cur = queue.poll();
						int x = cur / n;
						int y = cur % n;
						for (int[] d : dir) {
							int a = x + d[0];
							int b = y + d[1];
							if (a >= 0 && a < m && b >= 0 && b < n && !visited[a][b] && grid[a][b] == 0) {
								queue.add(a * n + b);
								visited[a][b] = true; // keep shorest for one house
								dist[a][b] += distance + 1; // accumulative with multiple "1"s
								reach[a][b]++;
							}
						}
					}
					distance++;
				}
			}
		}
	}

	int min = Integer.MAX_VALUE;
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			if (grid[i][j] == 0 && reach[i][j] == buildingNum) {
				min = Math.min(min, dist[i][j]);	
			}	
		}
	}

	return min == Integer.MAX_VALUE ? -1 : min;
}

