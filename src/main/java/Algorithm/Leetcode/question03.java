package Algorithm.Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 */
public class question03 {
    public static void main(String[] args) {
        String s="abba";
        int count=lengthOfLongestSubstring(s);
        System.out.println(count);
    }
    public static  int lengthOfLongestSubstring(String s) {
        int left=0;
        int right=0;
        int count=0;
        Map<Character, Integer> map=new HashMap<Character, Integer>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                int index=map.get(s.charAt(i));
                if(left<=index) {
                    left = index + 1;
                }
            }
            map.put(s.charAt(i),i);
            right+=1;
            if(count<right-left){
                count=right-left;
            }
        }
        return count;
    }
}
