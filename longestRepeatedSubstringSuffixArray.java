import java.util.Arrays;

public class SuffixArray {
	public static String lrs(String s){
		int N = s.length();
		String[] suffixes = new String[N];
		for(int i=0;i<N;i++){
			suffixes[i] = s.substring(i);
		}
		Arrays.sort(suffixes);
		String ret ="";
		for(int i=0;i<N-1;i++){
			int len = lcp(suffixes[i],suffixes[i+1]);
			if (len > ret.length()){
				ret = suffixes[i].substring(0,len);
			}
		}
		return ret;
	}
	
	public static int lcp (String s1, String s2){
		int i = 0;
		while (i < s1.length()){
			if (i >= s2.length() || s1.charAt(i)!=s2.charAt(i)){
				break;
			}
			i++;
		}
		return i;
	}
	
	public static void main(String[] args){
		System.out.println(SuffixArray.lrs("aababa"));
		System.out.println(SuffixArray.lrs("abcabcaacb"));
	}
}
