import java.util.Arrays;
import java.util.Comparator;
public class ConcatNums {
    public String biggestNum(String[] nums) {
        Arrays.sort(nums, new Comparator<String>(){
            public int compare(String x, String y){
                String xy = x + y;
                String yx = y + x;
                int i = 0;
                while (i<xy.length()){
                    if (xy.charAt(i) == yx.charAt(i)){
                        i++;
                    }
                    else return yx.charAt(i) - xy.charAt(i);
                }
                return 0;
            }
        });
        StringBuffer sb = new StringBuffer();
        for(String s:nums){
            sb.append(s);
        }
        return sb.toString();
    }
}