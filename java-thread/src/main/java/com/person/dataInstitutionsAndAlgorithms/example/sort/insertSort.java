package com.person.dataInstitutionsAndAlgorithms.example.sort;

/**
 * @author  hq
 * @description 插入排序
 */
public class insertSort {

    public static void main(String[] args) {
        int [] arr = {5,3,6,1,2,9,8,7,4};
        sort(arr);
        print(arr);
    }

     public  static void sort(int[] arr) {
          for(int i=1;i<arr.length;i++){ //由于与前面值比较所以从索引1开始
              for(int j =i;j>0;j--){ //当前索引值与前面的索引值比较
                  if(arr[j] <arr[j-1]){
                      swap(arr,j,j-1);
                  }
              }
          }
    }
    private static void swap(int [] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static void print(int [] arr){
        for(int element : arr){
            System.out.print(element + "\t");
        }
        System.out.println();
    }
}
