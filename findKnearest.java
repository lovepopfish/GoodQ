/** find K nearest point
 *  @param array, the input array of Point; k, number of nearest points
 *  @return Point[], Top K nearest points
 *
 * Approach: Maintain a K nodes Max Heap, iterating through the Point[] array,
 * put first K point into heap, and then as the iteration continue, if there
 * is a element smaller than the top of the max Heap, remove the top element
 * and insert new element into the heap, finally, we can get the top K
 * nearest points.
 *
 * Reason for the approach: Because Max Heap has the property that every
 * parent node greater than or equal to its children, so, if there is a
 * element smaller than top element, top element will become (K+1)th nearest
 * point, we need to remove the top, and put the current element into the
 * heap, continue this precedure until we reach the end of array.
 *
 * Runtime Complexity: nlog(k), where n is the number of points in the
 * given array, and k is the number of nearest points we are looking for
 * (Heap size). Because all of delete-max, insert operation will
 * take log(k) time, and there is N points totally,
 * which gives to nlog(k) time complexity.
 *
 *
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class findKnearest {
	private PriorityQueue<Point> maxHeap;
	private class Point{
		int x;
		int y;
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public Point[] createPoint(){
		Point[] array = new Point[10];
		array[0] = new Point(7,5);
		array[1] = new Point(4,3);
		array[2] = new Point(1,2);
		array[3] = new Point(1,-2);
		array[4] = new Point(8,0);
		array[5] = new Point(-1,-2);
		array[6] = new Point(0,0);
		array[7] = new Point(1,0);
		array[8] = new Point(0,2);
		array[9] = new Point(0,-1);
		return array;
	}
	private class MaxHeapComparator implements Comparator<Point>{
		public int compare(Point o1, Point o2){
			double dist1 = dist(o1);
			double dist2 = dist(o2);
			if (dist1 < dist2) return 1;
			else if (dist1==dist2) return 0;
			else return -1;
		}
	}
	
	private double dist(Point p){
		return Math.sqrt(p.x*p.x + p.y*p.y);
	}
    
	public Point[] K_N (Point[] array, int k){
		maxHeap = new PriorityQueue<Point>(10, new MaxHeapComparator());
		for (int i=0;i<array.length;i++){
			if (i<k) {
				maxHeap.offer(array[i]);
			} else{
				if (dist(array[i]) < dist(maxHeap.peek())){
					maxHeap.poll();
					maxHeap.offer(array[i]);
                }
            }
        }
		return maxHeap.toArray(new Point[maxHeap.size()]);
	}
	public static void main(String[] args){
		findKnearest f = new findKnearest();
		Point[] point = f.createPoint();
		Point[] ret = f.K_N(point, 3);
		for (Point i:ret){
			System.out.println(i.x + "," + i.y);
		}
	}
}
