import java.util.ArrayList;

public class zeroOneBagProblem{
	int[][] table;
	int capacity;
	int N;
	ArrayList<Diamond> list;
	private class Diamond{
		int weight;
		int val;
		public Diamond(int w, int v){
			this.weight = w;
			this.val = v;
		}
	}
	
	public ArrayList<Diamond> createDiamond(){
		ArrayList<Diamond> list = new ArrayList<Diamond>();
		Diamond a = new Diamond(4,9);
		Diamond b = new Diamond(3,6);
		Diamond c = new Diamond(5,1);
		Diamond d = new Diamond(2,4);
		Diamond e = new Diamond(5,1);
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		list.add(e);
		return list;
	}
	
	public void createTable(ArrayList<Diamond> list, int bagCapacity){
		this.capacity = bagCapacity;
		this.N = list.size();
		this.list = list;
		int row = bagCapacity;
		int col = list.size();
		int[][] dp = new int[row+1][col+1];
		for(int i=1;i<row+1;i++){
			for(int j=1;j<col+1;j++){
				dp[i][j] = dp[i][j-1];
				if (i >= list.get(j-1).weight) {
					dp[i][j] = Math.max(dp[i][j], dp[i-list.get(j-1).weight][j-1] + list.get(j-1).val);
				}
			}
		}
		this.table = dp;
	}
	
	public int findMaxVal(){
		return table[capacity][N];
	}
	
	public int[] findPickedDiamond(){
		int[] arr = new int[N];
		int C = capacity;
		for(int j=N;j>0;j--){
			if (table[C][j] > table[C][j-1]){
				arr[j-1] = 1;
				C = C - list.get(j-1).weight;
			}
		}
		return arr;
	}
	
	public static void main(String[] args){
		zeroOneBagProblem bag = new zeroOneBagProblem();
		ArrayList<Diamond> list = bag.createDiamond();
		bag.createTable(list, 10);
		int maxVal = bag.findMaxVal();
		System.out.println("MAX VALUE--->" + maxVal);
		int[] picked = bag.findPickedDiamond();
		for(int i : picked){
			System.out.print(i + " ");
		}
		
	}
}
