package com.person.dataInstitutionsAndAlgorithms.example.sort;

/**
 * 考虑问题：
 *    思路：
 *       01：当自己拿到一个问题，假如自己一点头绪都没有，这是要将这个问题细分，一步一步的实现，从简单到复杂；
 *       02：一步一步的验证；
 * @author  hq
 * @description 选择排序
 */
public class SelectionSort {

    public static void main(String[] args) {
        int [] arr = {5,3,6,1,2,9,8,7,4};

        //--------需求：将数组进行从小到大的排序------------
        //思路1.先拿最小值位置:假设第一个值就是最小值
        int minPos = 0;
        for(int j= 0; j<arr.length;j++){
            if(arr[j] < arr[minPos]){
                minPos = j;

            }
        }
        System.out.println(minPos); //验证
        //---数据交换----
        int temp = arr[0];
        arr[0] = arr[minPos];
        arr[minPos] = temp;
        System.out.println(arr[0]); //验证
        //先验证数据的正确性
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
        selectionSort(arr); //推导出一下正确的快速排序
        selectionSort02(arr);

    }

    /**
     *快速排序
     * @param arr
     */
    public static void selectionSort(int [] arr) {

        for(int i= 0;i<arr.length;i++){
            int minPos = i;
            for(int j= i+1;j<arr.length;j++){ //那当前索引位置的值与后面的位置的值比较
               minPos = arr[j] < arr[minPos] ? j:minPos;
                //数据交换
                int temp = arr[i];
                arr[i] =arr[minPos];
                arr[minPos] = temp;
            }

            for(int k=0;k<arr.length;k++){
                System.out.print(arr[k] + "\t");
            }
            System.out.println();

        }
        print(arr); //数据校验
    }
    /**
     *快速排序优化版:少两次排序
     * @param arr
     */
    public static void selectionSort02(int [] arr) {

        for(int i= 0;i<arr.length-2;i++){
            int minPos = i;
            int maxPos = arr.length-1;
            for(int j= i+1;j<arr.length;j++){ //那当前索引位置的值与后面的位置的值比较
                minPos = arr[j] < arr[minPos] ? j:minPos;
                maxPos = arr[j] > arr[maxPos] ? j:maxPos;
            }
            exchange(arr,i,minPos,maxPos); //数据交换
           /* for(int k=0;k<arr.length;k++){
                System.out.print(arr[k] + "\t");
            }
            System.out.println();*/
        }
        //print(arr); //数据校验
    }
   static void exchange(int []arr,int i,int minPos,int maxPos){
        int index = arr.length-1;
       int temp = arr[i];
       arr[i] =arr[minPos];
       arr[minPos] = temp;
       temp = arr[index];
       arr[index] = arr[maxPos];
       arr[maxPos] = temp;
       index--;

   }
   static  void print(int[] arr){
       for(int i=0;i<arr.length;i++){
           System.out.print(arr[i] + "\t");
       }
       System.out.println();
   }
}
