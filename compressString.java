
public class CompressString {
	public static String compress(String s){
		if (s.length()==0) return null;
		int len = calculateLength(s);
		if (len > s.length()) return s;
		String newString = "";
		int count = 1;
		char last = s.charAt(0);
		for (int i=1;i<s.length();i++){
			if (s.charAt(i)==last) {
				count++;
			} else {
				newString += last + "" + count;
				count = 1;
				last = s.charAt(i);
			}
		}
		newString += last + "" + count;
		return newString;
	}
	private static int calculateLength(String s){
		int count = 1;
		char c  = s.charAt(0);
		for (int i=1;i<s.length();i++) {
			if (s.charAt(i)!=c) {
				count++;
				c = s.charAt(i);
			}
		}
		return count * 2;
	}
	
	public static String compress2(String s){
		if (s.length()==0) return null;
		int len = calculateLength(s);
		if (len > s.length()) return s;
		StringBuffer sb = new StringBuffer();
		int count = 1;
		int last = s.charAt(0);
		for (int i=1;i<s.length();i++){
			if (s.charAt(i)==last){
				count++;
			} else {
				sb.append(last + "" + count);
				last = s.charAt(i);
				count = 0;
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args){
		System.out.println("" + CompressString.compress(""));
		System.out.println("a----->" + CompressString.compress("a"));
		System.out.println("aaaaaaa----->" + CompressString.compress("aaaaaaa"));
		System.out.println("abcdefg----->" + CompressString.compress("abcdefg"));
		System.out.println("aaabbbccdeee----->" + CompressString.compress("aaabbbccdeee"));
	}
}
