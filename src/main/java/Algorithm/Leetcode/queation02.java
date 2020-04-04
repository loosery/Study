package Algorithm.Leetcode;

import java.util.List;

/**02 两数之和
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class queation02 {
    public static void main(String[] args) {
        int[] a={4,3};
        int[] b={6,4};
        ListNode listNode1=new ListNode(2);
        ListNode listNode2=new ListNode(4);
        ListNode listNodea=getLsistNode(listNode1,a,0);
        ListNode listNodeb=getLsistNode(listNode2,b,0);
        printListNode(listNodea);
        System.out.println("第二个开始");
        printListNode(listNodeb);
        addTwoNumbers(listNodea,listNodeb);
        System.out.println("第三个开始");
        printListNode(listNodea);


    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1.next==null&&l2.next==null){
            l1.val=l1.val+l2.val;
            if(l1.val>=10){
                l1.next=new ListNode(1);
                l1.val=l1.val-10;
            }
            return l1;
        }
        if(l1.next==null){
            l1.next=new ListNode(0);
        }else if(l2.next==null){
            l2.next=new ListNode(0);
        }
        l1.val+=l2.val;
        if(l1.val>=10){
            l1.val-=10;
            l1.next.val+=1;}
        addTwoNumbers(l1.next,l2.next);
        return l1;
    }
    public static ListNode getLsistNode(ListNode l1,int[] a,int index){
        if(index==a.length){
            return l1;
        }
        l1.next=new ListNode(a[index]);
        index+=1;
        getLsistNode(l1.next,a,index);
        return l1;
    }
    public static void printListNode(ListNode l1){
        if (l1.next==null) {
            System.out.println(l1.val);
            return;
        }
        System.out.println(l1.val);
        printListNode(l1.next);

    }
}
class ListNode {
      int val;
      ListNode next;
    ListNode(int x) { val = x; }

    public int getVal() {
        return val;
    }

}