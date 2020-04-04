package Algorithm.Leetcode;

import java.util.HashMap;
import java.util.Map;

/**1.两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */
public class question01 {
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        Map<Integer,Integer> map=new HashMap();
            for(int i=0;i<nums.length;i++){
                map.put(nums[i],i);
            }
            for(int j=0;j<nums.length;j++){
                int count=target-nums[j];
                if(map.containsKey(target-nums[j])&&(map.get(count)!=j)){
                    return new int[]{j,count};
                }
            }
            throw new RuntimeException("没有符合的两数");
    }
}
