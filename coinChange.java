
public class CoinChange {
	public int count(int[] num, int target){
		return count(num,target,0);
	}
	private int count(int[] num, int target, int pos){
		if (target==0) return 1;
		if (target < 0) return 0;
		if (pos == num.length && target>0) return 0;
		return count(num,target,pos+1) + count(num,target-num[pos],pos);
	}
	
	public int countDP(int[] num, int target){
		int n = num.length;
		int m = target;
		int[][] dp = new int[m+1][n];
		for (int i=0;i<n;i++){
			dp[0][i] = 1;
		}
		for (int i=1;i<=m;i++){
			for (int j=0;j<n;j++){
				dp[i][j] = i-num[j] >=0? dp[i-num[j]][j] : 0;
				dp[i][j] += j>0? dp[i][j-1] : 0;
			}
		}
		return dp[m][n-1];
	}
	
	public int countMinimalDP(int[] num, int target){
		int n = num.length;
		int m = target;
		int[][] dp = new int[m+1][n];
		for (int i=1;i<=m;i++){
			dp[i][0] = i;
		}
		for (int i=1;i<=m;i++){
			for (int j=1;j<n;j++){
                dp[i][j] = i - num[j] >= 0? Math.min(dp[i-num[j]][j]+1,dp[i][j-1]):dp[i][j-1];
			}
		}
		return dp[m][n-1];
	}
	
	public static void main(String[] args){
		CoinChange c = new CoinChange();
		System.out.println(c.count(new int[]{1,2,3},5));
		
	}
}
