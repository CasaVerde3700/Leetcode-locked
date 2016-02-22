// Factors should be greater than 1 and less than n.
public class Solution {
	public List<List<Integer>> getFacotorPerm(int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>;
		List<Integer> item = new ArrayList<>();
		helper(res, item, n, 2);
	}

	public void helper(List<List<Integer>> res, List<Integer> item, int n, int start) {
		for (int i = 2; i < n && 
			n % i == 0 && // factor
			n / i >=i && // ascending and deduplicate
			i >= start // ascending and deduplicate
			; i++) {

			item.add(i);
			item.add(n / i);

			res.add(item);

			item.remove(item.size() - 1);
			helper(res, item, n / i, i); // deeper
			item.remove(item.size() - 1);
		}
	}
}