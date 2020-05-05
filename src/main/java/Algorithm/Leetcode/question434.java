package Algorithm.Leetcode;


/**434. 字符串中的单词数
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 */
public class question434 {
    public static void main(String[] args) {

    }
    public int countSegments(String s) {
        String[] arr=s.split(" ");
        int count=0;
        for (String s1:arr){
            if (s1.length()>0&&s1!=" "){
                count++;
            }
        }
        return count;
    }
}
