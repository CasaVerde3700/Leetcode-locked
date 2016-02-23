/*
There are a row of n houses, each house can be painted with 
one of the k colors. The cost of painting each house with a 
certain color is different. You have to paint all the houses 
such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented 
by a n x k cost matrix. For example, costs0 is the cost of painting 
house 0 with color 0; costs1 is the cost of painting house 1 with 
color 2, and so on... Find the minimum cost to paint all houses.

Note: All costs are positive integers.

Follow up: Could you solve it in O(nk) runtime?
*/

// update array value, and get min & secmin at the same time

public int minCostII(int[][] costs) {
	int preMin = 0;
	int preSec = 0;
	int preIdx = 0;

	for (int i = 0; i < costs.length; i++) {
		int curMin = Integer.MAX_VALUE;
		int curSec = Integer.MAX_VALUE;
		int curIdx = -1;
		for (int j = 0; j < costs.length; j++) {
			cost[i][j] += preIdx == j ? preSec : preMin;
			if (cost[i][j] < curMin) {
				curSec = curMin;
				curMin = cost[i][j];
				curIdx = j;
			} else if (cost[i][j]< curSec) {
				curSec = cost[i][j];
			}
			
		}
		preMin = curMin;
		preSec = curSec;
		preIdx = curIdx;
	}

	return preMin;
}