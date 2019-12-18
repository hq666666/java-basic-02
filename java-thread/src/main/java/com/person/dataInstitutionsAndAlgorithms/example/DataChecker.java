package com.person.dataInstitutionsAndAlgorithms.example;

import com.person.dataInstitutionsAndAlgorithms.example.sort.SelectionSort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * @author hq
 * @description 验证算法:对数器
 */
public class DataChecker {

    public static void main(String[] args) {
        //-----------验证快速排序-------------
        check();
    }

    private static void check() {
        Random random = new Random();
        int [] arr = new int[10000];
        for(int i=0;i<arr.length;i++){
            arr[i] = random.nextInt(10000);
        }
        int []arr2 = new int[arr.length];
        arr2 = Arrays.copyOf(arr,arr.length);
        Arrays.sort(arr); //系统自带的算法
        SelectionSort.selectionSort02(arr2); //自己的选择算法
         boolean same = true;
        for(int j=0;j<arr.length;j++){
              if(arr[j] != arr2[j]) {
                  same = false;
              }
        }
        System.out.println(same? "right":"wrong");
    }
}
