
public class QuickSelectKth {
	public static int findKth (int[] arr, int k){
		if (arr.length == 0||arr.length < k){
			throw new Error("Invalid Input");
		}
		return findKth(arr,k,0,arr.length-1);
	}
	private static int findKth(int[] arr, int k, int left, int right){
		if (left == right) return arr[left];
		int index = partition(arr,left,right);
		if (k<=index) {
			return findKth(arr,k,left,index-1);
		}else {
			return findKth(arr,k,index,right);
		}
	}
	
	private static int partition(int[] arr, int left, int right){
		int mid = arr[(left+right)/2];
		while (left<=right) {
			while (arr[left] < mid){
				left++;
			}
			while (arr[right] > mid){
				right--;
			}
			if (left<=right){
				int tmp = arr[left];
				arr[left] = arr[right];
				arr[right] = tmp;
				left++;
				right--;
			}
		}
		return left;
	}
	
	public static void main(String[] args){
		int[] a = new int[]{1,3,5,7,8,9,0,8,7,-1,6,5,5};
		int[] b  = new int[]{0,1,1,0,0,1,1};
		int[] c = new int[]{0,0,0,0,0,0,0};
		int[] d = new int[]{2,1};
		int[] f = new int[]{-3,-2,-1,0,0,0,1,2,-3,-2,-1};
		int[] g = new int[]{6,5,4,3,3,2,1};
		System.out.println(QuickSelectKth.findKth(a, 3) + " ");
		System.out.println(QuickSelectKth.findKth(b, 3) + " ");
		System.out.println(QuickSelectKth.findKth(c, 3) + " ");
		System.out.println(QuickSelectKth.findKth(d, 1) + " ");
		System.out.println(QuickSelectKth.findKth(f, 3) + " ");
		System.out.println(QuickSelectKth.findKth(g, 3) + " ");
	}
}
