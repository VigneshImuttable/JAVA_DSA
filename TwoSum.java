import java.util.*;

public class TwoSum {


    public static void main(String[] args) {
        int[] q = {3,2,4};
        TwoSum tw = new TwoSum();
        int [] a = tw.twoSum(q,6);
        for(int i:a) System.out.println(i);
    }


    //Letcode: https://leetcode.com/problems/two-sum/
    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i],map.get(nums[i])+1);
            else map.put(nums[i],1);
        }
        int[] ans = new int[2];
        for(int i=0; i<nums.length; i++){
            int tempTarget = target-nums[i];

            if(tempTarget==nums[i]){
                if(map.get(tempTarget)>1){
                    int count =0;
                    for(int j=0; j<nums.length; j++){
                        if(nums[j]==tempTarget){
                            ans[count] = j;
                            count++;
                        }
                        if(count==2) break;
                    }
                }
            }
            else if(map.containsKey(tempTarget)){
                ans[0] = i;
                for(int j=0; j<nums.length; j++){
                    if(nums[j]==tempTarget){
                        ans[1] = j;
                        break;
                    }
                }

            }
        }

        return ans;

    }

}

/** Leetcode soln
 * public int[] twoSum(int[] nums, int target) {
 *         Map<Integer, Integer> map = new HashMap<>();
 *         for (int i = 0; i < nums.length; i++) {
 *             int complement = target - nums[i];
 *             if (map.containsKey(complement)) {
 *                 return new int[] { map.get(complement), i };
 *             }
 *             map.put(nums[i], i);
 *         }
 *         // In case there is no solution, we'll just return null
 *         return null;
 *     }
 */
