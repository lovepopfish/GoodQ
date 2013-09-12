/** Quick Select to get Top K smallest number
 *
 *  Approach: When we do each partition, we divide the array into two parts. One part is smaller
 *  than the pivot element, and the other part is greater than the pivot element.
 *  Each time, it will return the index of how many element in the left side. (or we can
 *  say that it is the leftmost element in the right side). So, if K equals to the
 *  return element, we can simply copy the range of array from beginning to k. if K less
 *  than the return element, we need to search left continuously; Or we search the right
 *  part.
 *
 *	Runtime Complexity: O(n) ?
 *
 */
public class QuickSelectFirstK {
	public static int[] topK(int[] arr, int k){
		if(arr.length == 0 || arr.length < k){
			throw new Error("Invalid Input");
        }
		return topK(arr,k,0,arr.length-1);
        
	}
    
	private static int[] topK(int[] arr, int k, int left, int right){
		int index = partition(arr, left, right);
		if (k == index) return java.util.Arrays.copyOfRange(arr, 0,k);
		if(k < index){
			return topK(arr,k,left,index-1);
		}else{
			return topK(arr,k,index,right);
		}
	}
	
	private static int partition(int[] arr, int left, int right){
		int m = arr[(left + right)/2];
		while(left <= right){
			while(arr[left] < m){
				left++;
            }
			while(arr[right] > m){
				right--;
            }
			if(left<=right){
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
		
		for (int i:QuickSelectFirstK.topK(a, 3)){
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i:QuickSelectFirstK.topK(b, 3)){
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i:QuickSelectFirstK.topK(c, 3)){
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i:QuickSelectFirstK.topK(d, 1)){
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i:QuickSelectFirstK.topK(f, 3)){
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i:QuickSelectFirstK.topK(g, 3)){
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
