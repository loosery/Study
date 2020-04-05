package Algorithm.Leetcode;

/**
 * 50 Pow(x,n)
 * 计算m的n次幂
 */
public class question50 {
    public static void main(String[] args) {
       double s= myPow(1.00000
             , -2147483648);
       double x=Math.pow(34.00515,-3);
        System.out.println(x);
        System.out.println(s);

    }
    public static double myPow(double x, int n) {//有栈溢出风险
        if(n==0){
            return 1;
        }
        else if(n<0){
            return 1/myPow(x,-n);
        }
        if(n%2==0){
            return myPow(x*x,n/2);
        }else{
            return myPow(x*x,n/2)*x;
        }
    }

//    public double myPow(double x, int n) {
//        if(n>0){
//            return myPowA(x,n);
//        }else if(n==0){
//            return 1;
//        }else{
//            return 1/myPowA(x,-n);
//        }
//    }
//    public static double myPowA(double x, int n){
//        if(n/2==0){
//            return x;
//        }
//        if(n%2==0){
//            return myPowA(x*x,n/2);
//        }else{
//            return myPowA(x*x,n/2)*x;
//        }
//    }
}
