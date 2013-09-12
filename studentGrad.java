/** find each student top five average score
 *
 * @param List<TestResult> resultlist, the list contains all of the student record
 * @output Map<Integer,Double> ret, the result contains the average of top 5 score of each student
 *
 *
 * Approach: Built a 5 nodes MinHeap on each of the students to find Top 5 high score of,
 * each student and store in HashMap with corresponding studentId, as HashMap<Integer, PriorityQueue<Integer>>
 * After iterating through the TestResult set, finally we will get top five
 * score of each student. And then, we calculate the average score of each
 * student and store the final average score with studentId into HashMap<Integer,Double>
 *
 * Reason for approach: Because it assumes that each student has more than 5 records, so
 * we can use minHeap collect data, for each of student, we read in first 5 score, as the
 * property of MinHeap that every parent node smaller than or equal to its children,
 * when the iterate continue, it there is a element greater than the top element of minHeap,
 * top element will become (5+1)th largest score, we need to remove the top, and put the
 * current element into the heap. Because each student has unique id, we need to build
 * different minHeap on different students, so we choose HashMap<Integer,PriorityQueue<Integer>>
 *
 * Runtime Complexity: nlog(k), where n is the number of record in the given set, and k
 * is the number of top score we are looing for (minHeap size). Because all of delete-min
 * insert operation will take log(k) time, and there is N record totally, which givens to
 * nlog(k) time complexity.
 *
 *
 */



import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class StudentGrad {
	public class TestResult{
		int studentId;
		String testDate;
		int testScore;
        public TestResult(int studentId, String testDate, int testScore){
            this.studentId = studentId;
            this.testDate = testDate;
            this.testScore = testScore;
		}
	}
	
	public List<TestResult> create(){
		List<TestResult> list = new LinkedList<TestResult>();
		list.add(new TestResult(0,"Monday",0));
		list.add(new TestResult(0,"Monday",0));
		list.add(new TestResult(0,"Monday",5));
		list.add(new TestResult(0,"Monday",5));
		list.add(new TestResult(0,"Monday",5));
		list.add(new TestResult(1,"Monday",1));
		list.add(new TestResult(1,"Monday",6));
		list.add(new TestResult(1,"Monday",7));
		list.add(new TestResult(2,"Monday",0));
		list.add(new TestResult(2,"Monday",0));
		list.add(new TestResult(2,"Monday",0));
		list.add(new TestResult(2,"Monday",0));
		list.add(new TestResult(2,"Monday",0));
		list.add(new TestResult(2,"Monday",0));
		list.add(new TestResult(0,"Monday",0));
		list.add(new TestResult(0,"Monday",5));
		list.add(new TestResult(0,"Monday",5));
		list.add(new TestResult(1,"Monday",2));
		list.add(new TestResult(1,"Monday",3));
		list.add(new TestResult(1,"Monday",4));
		list.add(new TestResult(1,"Monday",5));
		return list;
	}
	
	public Map<Integer,Double> getFinalScores(List<TestResult> resultlist){
		Map<Integer,Double> map = new HashMap<Integer,Double>();
		Map<Integer,PriorityQueue<Integer>> mapHeap = new HashMap<Integer,PriorityQueue<Integer>>();
		for (TestResult i:resultlist){
			if (mapHeap.get(i.studentId)==null){
				PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
				heap.add(i.testScore);
				mapHeap.put(i.studentId,heap);
			} else{
				PriorityQueue<Integer> heap = mapHeap.get(i.studentId);
				if (heap.size()<5) {
					heap.add(i.testScore);
				} else {
					if (i.testScore > heap.peek()){
						heap.poll();
						heap.add(i.testScore);
					}
				}
			}
		}
		
		for (Integer i:mapHeap.keySet()){
			double mean = 0;
			PriorityQueue<Integer> heap = mapHeap.get(i);
			Integer[] score = heap.toArray(new Integer[heap.size()]);
			for (int j:score){
				mean+=j/score.length;
			}
			map.put(i, mean);
		}
		return map;
	}
	
	public static void main(String[] args){
		StudentGrad s = new StudentGrad();
		List<TestResult> list = s.create();
		Map<Integer,Double> ret = s.getFinalScores(list);
		for (Integer i:ret.keySet()){
			System.out.println("ID--->" + i + "   Score---->" + ret.get(i));
		}
	}
}
