import java.util.Comparator;
import java.util.PriorityQueue;


public class Stream {
	private PriorityQueue<Integer> minHeap;
	private PriorityQueue<Integer> maxHeap;
	int max;
	int min;
	double average;
	double median;
	int N;
	public Stream(){
		minHeap = new PriorityQueue<Integer>();
		maxHeap = new PriorityQueue<Integer>(11, new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2){
				return o2 - o1;
			}
		});
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		average = 0;
		median = 0;
		N = 0;
	}
	
	public void insertAndPrint(int v){
		readInteger(v);
		System.out.println("Max is--->" + max);
		System.out.println("Min is--->" + min);
		System.out.println("Median is--->" + median);
		System.out.println("Average is--->" + average);
	}
	
	public void readInteger(int v){
		this.N++;
		if (minHeap.size() == maxHeap.size()){
			if (!maxHeap.isEmpty() && v > minHeap.peek()){
				maxHeap.offer(minHeap.poll());
				minHeap.offer(v);
			} else {
				maxHeap.offer(v);
			}
		} else {
			if (v < maxHeap.peek()){
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(v);
			} else {
				minHeap.offer(v);
			}
		}
		
		if (minHeap.size()==maxHeap.size()){
			median = (minHeap.peek() + maxHeap.peek())/2.0;
		} else {
			median = maxHeap.peek();
		}
		if (v < min) min = v;
		if (v > max) max = v;
		average = (average * (N-1) + v) / N;
	}
	
	public int getMax(){
		return max;
	}
	
	public int getMin(){
		return min;
	}
	
	public double getAverage(){
		return average;
	}
	
	public double getMedian(){
		return median;
	}
	
	public static void main(String[] args){
		Stream stream = new Stream();
		int[] nums = {1,8,3,7,9,0,2,6};
		for(int n:nums){
			stream.insertAndPrint(n);
			System.out.println("-------------");
		}
	}
}
