package datastructuresandalgorithms.day0504;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * &#x7a00;&#x758f;&#x6570;&#x7ec4;&#x4e0e;&#x4e8c;&#x7ef4;&#x6570;&#x7ec4;&#x4e4b;&#x95f4;&#x7684;&#x8f6c;&#x6362;
 * @author &#x6613;
 */
public class ArrayToSparse {
    public static void main(String[] args) throws IOException {
        int[][] arr=new int[6][6];
        arr[1][1]=1;
        arr[2][2]=2;
        System.out.println("原数组：");
        for (int[] row:arr){
            for (int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        int[][] sparse=twoToSparse(arr);
        System.out.println("稀疏数组");
        for (int[] row:sparse){
            for (int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        int[][] arr1=sparseToTwo(sparse);
        System.out.println("还原数组");
        for (int[] row:arr1){
            for (int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        writeArrayToFile(arr);
        int[][] arr2=readFileToArray("F:\\Sparse\\data.txt");
        System.out.println("读取数组");
        for (int[] row:arr2){
            for (int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

    }

    /**
     * 将二维数组转换成稀疏数组
     * @param arr 传入的二维数组
     * @return 稀疏数组
     */
    private static int[][] twoToSparse(int[][] arr){
        //首先获取有效数字的个数来创建稀疏数组
        int sum=0;
        for (int[] row : arr){
            for (int data:row){
                if (data!=0){
                    sum++;
                }
            }
        }
        //构建稀疏数组并赋值
        int[][] sparse = new int[sum+1][3];
        int height=arr.length;
        int width=arr[0].length;
        int count=0;
        sparse[0]=new int[]{height,width,sum};
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                if ( arr[i][j] !=0 ){
                    count++;
                    sparse[count]=new int[]{i,j,arr[i][j]};
                }
            }
        }
        return sparse;
    }

    /**
     * 将稀疏数组还原成原二维数组
     * @param sparse 稀疏数组
     * @return  原二维数组
     */
    private static int[][] sparseToTwo(int[][] sparse){
        //初始化原二维数组
        int[][] arr=new int[sparse[0][0]][sparse[0][1]];
        for (int i=1;i<sparse.length;i++){

            arr[sparse[i][0]][sparse[i][1]]=sparse[i][2];
        }
        return arr;
    }

    /**
     * 将二维数组写到磁盘上
     * @param arr 二维数组
     */
    private static void writeArrayToFile(int[][] arr) throws IOException {
        File file=new File("F:\\Sparse\\data.txt");
        FileWriter out=new FileWriter(file);
        for(int[] row:arr){
            for (int data:row){
                out.write(data+"\t");
            }
            out.write("\r\n");
        }
        out.close();
    }

    /**
     * 读取文件中的数据并转换成二维数组
     * @param fileName 文件名称
     * @return 二维数组
     * @throws IOException 一
     */
    private static int[][] readFileToArray(String fileName) throws IOException {
        BufferedReader reader= new BufferedReader(new FileReader(fileName));
        String temp;
        StringBuffer stringBuffer=new StringBuffer();
        int[] row;
        List<int[]> arrRow=new ArrayList<int[]>();
         while ((temp=reader.readLine())!=null){
            stringBuffer.append(temp);
            stringBuffer.append("&");
         }
         String data=stringBuffer.toString();
         String[] heightStr=data.split("&");
         String[] widthStr=heightStr[0].split("\t");
         int[][] arr=new int[widthStr.length][heightStr.length];
         int count=0;
         for (String rowData:heightStr){
             widthStr=rowData.split("\t");
             for ( int j=0;j<widthStr.length;j++){
                 arr[count][j]=Integer.parseInt(widthStr[j]);
             }
             count++;
         }
         return arr;


    }

}
