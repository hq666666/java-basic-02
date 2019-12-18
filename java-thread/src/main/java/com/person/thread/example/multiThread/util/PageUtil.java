package com.person.thread.example.multiThread.util;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author  hq
 * @description 根据指定处理的数据进行分批处理数据的工具类：
 *                 设计思想：根据分页计算公式得出；
 */
public class PageUtil {
    /**
     * 根据指定
     * @param list  处理数据的集合
     * @param pageSize 指定一个线程需处理的数据量
     * @param <T>
     * @return
     */
    public static <T>List<List<T>> getPageInfo(List<T> list,int pageSize){

        int listSize = list.size();
        //防止存于的数据量不足指定一个线程需完成的数据量
        int page = (listSize+(pageSize-1))/pageSize;
        List<List<T>> resutlList = new ArrayList<>();
        for(int i =1;i<=page;i++) { //页数
            List<T> subList = new ArrayList<>();
            int pageIndex =  (i-1)*pageSize;
            AtomicInteger startIndex = new AtomicInteger(pageIndex);
            int endSize =  listSize-startIndex.intValue();
            //处理最后不足指定需要处理的数据量
            if(i==page && endSize<pageSize){
                for(int k= 0;k<endSize;k++){
                    subList.add(list.get(startIndex.intValue()));
                    startIndex.incrementAndGet();
                }
           }else{
                for(int j=0;j<pageSize;j++){
                    subList.add(list.get(startIndex.intValue()));
                    startIndex.incrementAndGet();
                }
            }
           resutlList.add(subList);
        }
        return resutlList;
    }
}
