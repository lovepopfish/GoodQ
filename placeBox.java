/*积木的定义(请不要在代码中定义该结构)
 public class Box {
 int vol, weight;
 }*/
import java.util.*;
public class MaxBox {
    public int maxBoxes(Box[] boxes) {
        if (boxes.length == 0) return 0;
        Arrays.sort(boxes, new Comparator<Box>(){
            public int compare(Box o1, Box o2){
                return o1.vol - o2.vol;
            }
        });
        int len = 1;
        int[] dp = new int[boxes.length];
        dp[0] = 1;
        for(int i=1;i<boxes.length;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if (boxes[j].vol < boxes[i].vol && boxes[j].weight < boxes[i].weight){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            len = Math.max(len,dp[i]);
        }
        return len;
    }
}