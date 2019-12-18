package com.person.dataInstitutionsAndAlgorithms.example.sort;

/**
 * @author  hq
 * @description 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        //思路：找到数组指定位置的最大值；
        int [] arr = {5,3,6,1,2,9,8,7,4};
        sort(arr);
    }

    private static void sort(int[] arr) {

        for(int i=arr.length-1; i>0;i--){ //获取各个位置上的最大值；
            for(int j=0;j<i;j++){ //获取该数组的最大值
                if(arr[j] > arr[j+1]){
                    swap(arr,j,j+1); //交换位置
                }
            }
        }
        print(arr);
    }

    private static void swap(int[] arr,int i,int j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }

    private static void print(int[] arr) {
      for (int element : arr){
          System.out.print(element + "\t");
      }
        System.out.println();
    }
}
