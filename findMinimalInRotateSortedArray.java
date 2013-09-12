/** Find Minimal Element in a sorted rotated array
 *
 * @param arr, input sorted rotated array
 * @return the Minimal Element in the array
 *
 * Approach: We can use Binary Search to find the Minimal element.
 * The Key point is to find the "rotate point" where the Minimal element following
 * the largest element in the array.
 *
 * If there is no duplicate element:
 * We start with two pointer i and j point to start and end of the array respectively.
 * At each time, use (i + j)/2 to calculate the mid element, and compare mid element
 * to the ith element, if mid element larger than ith element, the "rotate point" should
 * be in the right half of the given range (exclusive mid element) we set i to mid + 1;
 * If mid element smaller than the ith element, "rotate point" should be in the left
 * half of the given range (inclusive the mid element) we set j to mid. And if mid element
 * equal to ith element, which means i == j - 1 (Assume there is no duplicate element),  just
 * pick the minimal element between ith and jth.
 *
 * And at each loop if element from ith to jth is sorted, the minimal element should be
 * the ith element.
 *
 * If there is duplicate element exists:
 * when mid element equals ith element, there are two possible situation.
 * 1. mid pointer and ith pointer point to the same element, where i == j - 1;
 * we simply pick the minmial element between i and j.
 * 2. arr[mid] = arr[i] , duplicate element, we simply let pointer i jump over the
 * duplicate element and repeat the whole procedure again.
 *
 * Reason for the approach: Because the sorted array is rotated, we can treat that
 * the array is partial sorted, so, by comparing mid element to the start element,
 * we can find which part is sorted. Because the "rotate point" is always locate in
 * the unsorted part, so each time we go for the unsorted part and repeat the procedure
 * until ith to jth is all sorted or there are two element left or i and j point to the same element.
 *
 *
 * Runtime Complexity: Because we use the binary search to find the minimal, the
 * time complexity given it to O(log(n)) in the average case, and in the worst case:
 * All of element are equal, the time complexity go back to O(n), because it need to
 * examine every element in the array.
 *
 *
 */
public class findMinimal {
	public int findMinUnrepeat(int[] arr){
		int i = 0;
		int j = arr.length - 1;
		while (i < j){
			if (arr[i] < arr[j]) return arr[i]; // if arr[i] to arr[j] is sorted, arr[i] should be the minimal element
			if (i == j -1) return Math.min(arr[i], arr[j]); //two element left (i==mid,arr[i]==arr[mid])
			int mid  = (i + j)/2;
			if (arr[mid] > arr[i]) {
				i = mid + 1;
			} else {
				j = mid;
			}
		}
		return arr[i];
	}
	
	public int findMinRepeat(int[] arr){
		int i = 0;
		int j = arr.length - 1;
		while (i < j){
			if (arr[i] < arr[j]) return arr[i];
			if (i == j - 1) return Math.min(arr[i], arr[j]);
			int mid = (i + j)/2;
			if (arr[mid] > arr[i]) {
				i = mid + 1;
			} else if (arr[mid] < arr[i]) {
				j = mid;
			} else {
				i++;
			}
		}
		return arr[i];
	}
	
	public static void main (String[] args){
		findMinimal min = new findMinimal();
		int[] a = new int[]{5,6,1,2,3,4};
		int[] b = new int[]{1,2,3,4};
		int[] c = new int[]{1};
		int[] d = new int[]{1,2};
	    int[] e = new int[]{5,6,7,1,2,3,4};
	    int[] f = new int[]{1,2,3,4,5,6,7};
	    int[] g = new int[]{2,3,4,5,6,7,8,1};
	    int[] h = new int[]{3,4,5,1,2};
	    System.out.println("The Minimal Element of {5,6,1,2,3,4} is---->" + min.findMinUnrepeat(a));
		System.out.println("The Minimal Element of {1,2,3,4} is---->" + min.findMinUnrepeat(b));
		System.out.println("The Minimal Element of {1} is---->" + min.findMinUnrepeat(c));
		System.out.println("The Minimal Element of {1,2} is---->" + min.findMinUnrepeat(d));
		System.out.println("The Minimal Element of {5,6,7,1,2,3,4} is---->" + min.findMinUnrepeat(e));
		System.out.println("The Minimal Element of {1,2,3,4,5,6,7} is---->" + min.findMinUnrepeat(f));
		System.out.println("The Minimal Element of {2,3,4,5,6,7,8,1} is---->" + min.findMinUnrepeat(g));
		System.out.println("The Minimal Element of {3,4,5,1,2} is---->" + min.findMinUnrepeat(h));
	    int[] i = new int[]{1,1,0,1};
	    int[] j = new int[]{1,1,2,2,3};
	    int[] k = new int[]{3,3,3,4,4,4,4,5,3,3};
	    int[] l = new int[]{2,2,2,2,2,2,2,2,0,1,1,2};
	    int[] m = new int[]{2,2,2,2,2,2,2,2,2,2,1,1};
	    int[] n = new int[]{2,2,2,0,2,2,2,2,2,2,2,2};
	    System.out.println("---------------------------------------------------------");
	    System.out.println("The Minimal Element of {1,1,0,1} is---->" + min.findMinRepeat(i));
		System.out.println("The Minimal Element of {1,1,2,2,3} is---->" + min.findMinRepeat(j));
		System.out.println("The Minimal Element of {3,3,3,4,4,4,4,5,3,3} is---->" + min.findMinRepeat(k));
		System.out.println("The Minimal Element of {2,2,2,2,2,2,2,2,0,1,1,2} is---->" + min.findMinRepeat(l));
		System.out.println("The Minimal Element of {2,2,2,2,2,2,2,2,2,2,1,1} is---->" + min.findMinRepeat(m));
		System.out.println("The Minimal Element of {2,2,2,0,2,2,2,2,2,2,2,2} is---->" + min.findMinRepeat(n));
		
	}
}
