
public class RankTree {
	private RankNode root = null;
	public void insert(int v){
		if (root==null) {
			root = new RankNode(v);
		} else {
			root.insert(v);
		}
	}
	
	public int getRank(int v){
		return root.getRank(v);
	}
	
	public static void main(String[] args){
		RankTree tree = new RankTree();
		int[] arr = {20,15,25,10,23,23,23,5,13,24};
		for(int v:arr){
			tree.insert(v);
		}
		System.out.println(tree.getRank(10));
	}
}



public class RankNode {
	int leftCount;
	int val;
	RankNode left, right;
	public RankNode (int v) {
		this.val = v;
		leftCount = 0;
	}
	
	public void insert (int v) {
		if (v <= val){
			if (left == null) {
				left = new RankNode(v);
			} else {
				left.insert(v);
			}
			leftCount++;
		} else {
			if (right == null) {
				right = new RankNode(v);
			} else {
				right.insert(v);
			}
		}
	}
	
	public int getRank(int v) {
		if (v == val) return leftCount;
		else if (v < val) {
			if (left == null) {
				return -1;
			} else {
				return left.getRank(v);
			}
		} else {
			if (right == null) {
				return -1;
			} else {
				int rightCount = right.getRank(v);
				if (rightCount == -1) {
					return -1;
				} else {
					return leftCount + 1 + rightCount;
				}
			}
		}
	}
}
