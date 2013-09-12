import java.util.Stack;

public class checkListPalindrome{
	private ListNode head = null;
	private class ListNode{
		int val;
		ListNode next;
		public ListNode(int v){
			this.val = v;
		}
	}
	public void createList1(){
		head = new ListNode(1);
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(3);
		head.next = a;
		head.next = b;
	}
	public void createList2(){
		head = new ListNode(1);
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(1);
		head.next = a;
		a.next = b;
		b.next = c;
	}
	public boolean isPalindrome(){
		return isPalindrome(head);
	}
	private boolean isPalindrome(ListNode head){
		ListNode n1 = head;
		ListNode n2 = head;
		Stack<Integer> stack = new Stack<Integer>();
		while(n2!=null && n2.next!=null){
			stack.push(n1.val);
			n1 = n1.next;
			n2 = n2.next.next;
		}
		if (n2!=null){
			n1 = n1.next;
		}
		while(n1!=null){
			if (n1.val!=stack.peek()){
				return false;
			}
			stack.pop();
			n1 = n1.next;
		}
		return true;
	}
	public static void main(String[] args){
		checkListPalindrome list1 = new checkListPalindrome();
		checkListPalindrome list2 = new checkListPalindrome();
		list1.createList1();
		list2.createList2();
		System.out.println(list1.isPalindrome());
		System.out.println(list2.isPalindrome());
	}
}