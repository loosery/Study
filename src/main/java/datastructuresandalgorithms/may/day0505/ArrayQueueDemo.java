package datastructuresandalgorithms.may.day0505;

import java.util.Scanner;

/**
 * 使用数组实现队列
 * @author yifan
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayQueue arrayQueue=new ArrayQueue(3);
        boolean flag=true;
        while (flag){
            System.out.println("请选择选项：");
            System.out.println("1.插入数据到队列");
            System.out.println("2.从队列中获取数据");
            System.out.println("3.遍历查看队列");
            System.out.println("4.查看队列首位");
            int choose=scanner.nextInt();
            switch (choose){
                case 1:
                    System.out.println("请输入插入的数据：");
                    int data=scanner.nextInt();
                    try {
                        arrayQueue.addQueue(data);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        int temp=arrayQueue.getQueue();
                        System.out.println("取出的数据为："+temp);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        arrayQueue.printQueue();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        arrayQueue.showQueueFirst();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    flag=false;
                    break;
            }
        }
    }
/**
 *  使用数组模拟队列
 */
static class ArrayQueue{
    private int maxSize;
    private int rear;
    private int front;
    private int[] arr;
    //构造方法
    public ArrayQueue(int maxSize){
        this.maxSize=maxSize;
        rear=0;//尾部位置
        front=0;//头部位置
        arr=new int[maxSize];
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear==front;
    }
    //判断数组是否满了
    public boolean isFull(){
        return rear==maxSize;
    }
    //向队列添加数据
    public void addQueue(int data){
        if (isFull()){
            throw new RuntimeException("队列已满");
        }
        arr[rear++]=data;
    }
    //从队列中取数据
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front++];
    }
    //遍历输出队列的数据
    public void printQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        for (int i=front;i<=rear;i++){
            System.out.printf("arr[%d]=%d",i,arr[i]);
            System.out.println();
        }
        System.out.println();
    }
    //展示队列的头数据
    public void showQueueFirst(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        System.out.printf("队列的头数据为"+arr[front]);
    }

}


}
