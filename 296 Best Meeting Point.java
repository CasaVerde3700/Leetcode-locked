/*
A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

For example, given three people living at (0,0), (0,4), and (2,2):

1 - 0 - 0 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (0,2) is an ideal meeting point, as the total travel
distance of 2+2+2=6 is minimal. So return 6.

横纵分离

时间 O(NM) 空间 O(NM)

为了保证总长度最小，我们只要保证每条路径尽量不要重复就行了. 
由于是曼哈顿距离，我们可以分开计算横坐标和纵坐标，结果是一样的。
所以我们算出各个横坐标到中点横坐标的距离，加上各个纵坐标到中点纵坐标的距离，就是结果了。

Reference: https://segmentfault.com/a/1190000003894693

*/

public int minDistance(int[][] grid) {
	List<Integer> rows = new ArrayList<>();
	List<Integer> cols = new ArrayList<>();
	for (int i = 0; i < grid.length; i++) {
		for (int j = 0; j < grid[0].length; j++) {
			if (grid[i][j] == 1) {
				rows.add(i);
				cols.add(j);
			}
		}
	}
	Collections.sort(cols);
	int sum = 0;
	int rowMid = rows.get(rows.size() / 2);
	int colMid = cols.get(cols.size() / 2);
	for (Integer x : rows) {
		sum += Math.abs(x - rowMid);
	}
	for (Integer y : cols) {
		sum += Math.abs(y - colMid);
	}
	return sum;
}
