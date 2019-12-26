package test.pers.YalongBai.test.handler;

import test.pers.YalongBai.test.utils.TestFathor;


public class ArraySortTest extends TestFathor {
    private static int[] tempArray;
    private static int[] tempArray2;
    private static int[] aux; //归并所需的辅助数组

    @Override
    public void init() {
        logger.info("初始化数组...");
        tempArray = new int[]{1,37, 11, 8, 73, 19, 111};
        tempArray2 = new int[]{2, 34, 55, 2, 2, 3, 19, 27, 3, 5};
        logger.info("初始化数组完成");
    }

    @Override
    public void handler() {


       /* long curTime1 = System.currentTimeMillis();
        bubbleSort(tempArray); // 第一中排序方式，冒泡排序
        print(tempArray);
        logger.info( "耗时==" + (System.currentTimeMillis() - curTime1 ) );

        *//**
         *  快速排序的基本思想：挖坑填数+分治法。
         *  快速排序使用分治法（Divide and conquer）策略来把一个串行（list）分为两个子串行（sub-lists）。
         * *//*
        //logger.info("快速排序");
        long curTime2 = System.currentTimeMillis();
        //quickSort(tempArray2, 0, tempArray2.length - 1);// 第二种排序方式，快速排序
        print(tempArray2);
        logger.info( "耗时==" + (System.currentTimeMillis() - curTime2 ) );
        logger.info("归并排序");
        long curTime3 = System.currentTimeMillis();
        mergeSort(tempArray);
        print(tempArray);
        logger.info( "耗时==" + (System.currentTimeMillis() - curTime3 ) );*/


        logger.info("堆排序");
        stackSort(tempArray);
    }

    /**
    * @Description: 基本思想 此处以大顶堆为例，堆排序的过程就是将待排序的序列构造成一个堆，选出堆中最大的移走，再把剩余的元素调整成堆，找出最大的再移走，重复直至有序。
    * @Param: 
    * @Return: 
    * @Auther: 白亚龙
    * @Date: 2019/12/27
    */
    private void stackSort(int[] tempArray) {


    }

    /**
    * @Description: 快速排序
    * 快速排序的基本思想：挖坑填数+分治法。
    * 快速排序使用分治法（Divide and conquer）策略来把一个串行（list）分为两个子串行（sub-lists）。
    * @Param:
    * @Return:
    * @Auther: 白亚龙
    * @Date: 2019/12/25
    */
    private void quickSort(int[] intArr, int start, int end) {

        if( intArr == null || start > end ) {
            return;
        }

        int left = start;
        int right = end;

        // 设置基准值
        int pivot = intArr[left];

        while ( left < right) {
            while ( left < right && pivot <= intArr[right] ) {
                right --;
            }
            intArr[left] = intArr[right];

            while ( left < right && pivot >= intArr[left] ) {
                left ++;
            }

            // 放置基准值，准备分治递归快排
            intArr[right] = pivot;
            quickSort(intArr, start, left - 1);
            quickSort(intArr, left + 1, end);
        }

    }

    /**
    * @Description: 冒泡方法实现数组排序,升序排序
    * @Param:
    * @Return:
    * @Auther: 白亚龙
    * @Date: 2019/12/24
    */
    public void bubbleSort(int[] tempArray) {

        logger.info("开始执行冒泡排序。");
        logger.info("第一步：验证数据：");
        if( tempArray == null || tempArray.length == 0) {
            logger.info("数据格式不正确！");
            return ;
        }
        logger.info("第二步：执行排序。");
        for ( int i = 0; i < tempArray.length - 1; i++ ){
            for ( int j = 0; j < tempArray.length - i -1; j++ ) {
                if( tempArray[j] > tempArray[j + 1] ) {
                    int temp = tempArray[j];
                    tempArray[j] = tempArray[j + 1];
                    tempArray[j + 1] = temp;
                }
            }
        }
        logger.info("排序完成！");
    }

    private void print(int[] intArr) {
        for (int i = 0; i < intArr.length; i++) {
            logger.info(intArr[i]);
        }

    }

        /**
        * @Description: 归并排序是建立在归并操作上的一种排序方法，归并算法是将两个及以上的有序表合并成一个有序列表的
         * 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
         * 归并排序可通过两种方式实现:
         *
         * 自上而下的递归
         * 自下而上的迭代
        * @Param: 
        * @Return: 
        * @Auther: 白亚龙
        * @Date: 2019/12/26
        */
    private void mergeSort( int[] intArray ) {
        logger.info("初始化数组");
        aux = new int[intArray.length];
        sort( intArray, 0, intArray.length - 1);
    }

    private void sort( int[] intArray, int start, int end) {
        if ( start >= end ) {
            return;
        }

        int mid = ( start + end ) / 2;

        //左边排序
        sort( intArray, start, mid);

        // 右边排序
        sort( intArray, mid + 1, end);

        merge( intArray, start, mid, end );
    }

        /**
        * @Description:
         *  该方法先将所有元素复制到aux[]中，然后在归并会a[]中。方法咋归并时(第二个for循环)
         *  进行了4个条件判断：
         *    - 左半边用尽(取右半边的元素)
         *    - 右半边用尽(取左半边的元素)
         *    - 右半边的当前元素小于左半边的当前元素(取右半边的元素)
         *    - 右半边的当前元素大于等于左半边的当前元素(取左半边的元素)
        * @Param: 
        * @Return: 
        * @Auther: 白亚龙
        * @Date: 2019/12/26
        */
    private void merge(int[] intArray, int start, int mid, int end ) {
        // 将 intArray[start...mid] intArray[mid...end]归并
        int i = start;
        int j = mid + 1;
        // 将所有元素复制到aux中
        for (int k = start; k <= end; k++) {
             aux[k] = intArray[k];
        }
         //执行四个条件判断
        for ( int k = start; k <= end; k ++) {
             if ( i > mid ) {
                 intArray[k] = aux[j++];
             } else if ( j > end ) {
                 intArray[k] = aux[i++];
             } else if ( aux[i] < aux[j] ) {
                 intArray[k] = aux[j++];
             } else {
                 intArray[k] = aux[i++];
             }
        }
    }
}
