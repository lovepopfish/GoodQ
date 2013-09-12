import java.util.Stack;


public class minStack {
	Stack<Integer> elements;
	Stack<Integer> min;
	Stack<Integer> max;
	public minStack(){
		elements = new Stack<Integer>();
		min = new Stack<Integer>();
		max = new Stack<Integer>();
	}
	
	public void push(int v){
		if (min.isEmpty() || v <= min.peek()){
			min.push(v);
		}
		if (max.isEmpty() || v >= max.peek()){
			max.push(v);
		}
		elements.push(v);
	}
	
	public void pop(){
		if (elements.isEmpty()) {
			throw new Error("No Elements in the stack");
		}
		Integer tmp = elements.pop();
		if (tmp == min.peek()) {
			min.pop();
		}
		if (tmp == max.peek()) {
			max.pop();
		}
	}
	
	public int getMax(){
		return max.peek();
	}
	
	public int getMin(){
		return min.peek();
	}
	
	public static void main(String[] args){
		minStack minstack = new minStack();
		minstack.push(1);
		minstack.push(0);
		minstack.push(2);
		System.out.println("The Max Value is -->" + minstack.getMax());
		System.out.println("The Min Value is -->" + minstack.getMin());
		minstack.pop();
		System.out.println("The Max Value is -->" + minstack.getMax());
		System.out.println("The Min Value is -->" + minstack.getMin());
		minstack.pop();
		System.out.println("The Max Value is -->" + minstack.getMax());
		System.out.println("The Min Value is -->" + minstack.getMin());
	}
}
