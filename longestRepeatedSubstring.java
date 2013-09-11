import java.util.HashSet;
import java.util.Set;

public class LongestRepeatedSubstring {
	public static String search(String s){
		for(int len = s.length() - 1; len >= 1; len--){
			Set<String> set = new HashSet<String>();
			for(int i = 0 ; i <= s.length() - len; i++){
				if (!set.contains(s.substring(i,i+len))){
					set.add(s.substring(i,i+len));
				} else {
					return s.substring(i,i+len);
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args){
		System.out.println(LongestRepeatedSubstring.search("aababa"));
		System.out.println(LongestRepeatedSubstring.search("abcabcaacb"));
	}
}
