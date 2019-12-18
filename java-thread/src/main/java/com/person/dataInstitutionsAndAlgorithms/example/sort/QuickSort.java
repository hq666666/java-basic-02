package com.person.dataInstitutionsAndAlgorithms.example.sort;

/**
 *思路： 定义一个轴点，从左边界和右边界向中间遍历，左半区从中找到比轴点大的值，右半区从中找到比轴点小的值；
 *  解决技巧：使用debug实现一步验证一步
 * @author hq
 * @description 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int [] arr = {5,3,6,1,2,9,8,7,6,4,10,6};
        sort(arr,0,arr.length-1);
        print(arr);
    }
    public static void sort(int [] arr,int leftBound, int rightBound){
            if(leftBound >= rightBound) { return; }
            int mid =  partition(arr,leftBound,rightBound);//分区
           sort(arr,0,mid-1); //左半区排序；
           sort(arr,mid+1,rightBound); //右半区排序
    }
    /**
     * 快速排序： 通过定义一个轴点，进行左右向中间搜索，左边找到大于轴点的值，右边找到小于轴点的值；
     * @param arr
     * @param i
     * @param j
     */
    private static int partition(int[] arr, int i, int j) {
       int pivot = j; //确定一个轴点
       int left = i;  //定义左边界
       int right = j-1; //定义右边界
        while(left <= right){ //最坏打算只有两个值
            while ( left<= right &&arr[left] <=arr[pivot]) { //
              left++;
            }
            while (left<= right && arr[right] >arr[pivot]){ //arr[right] >arr[pivot] 防止出现等同的值进行交换；
                right--;
            }
            System.out.println("before swap: left->"+left+" right->"+right);
            if(left<right){swap(arr,left,right);}//根据轴点值获取比轴点大值与比轴点小的值进行交换(防止与大值进行交换)；
            print(arr);
        }
      swap(arr,left,pivot); //上一次的交换，以换成比轴点大的值，所以需要将轴点与该位置的值进行交换；
      print(arr);
      return  left; //返回轴点位置
    }



    private static void swap(int [] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void print(int[] arr) {
        for(int element : arr){
            System.out.print(element + "\t");
        }
        System.out.println();
    }
}
