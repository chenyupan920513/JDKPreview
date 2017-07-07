package com.cyp.algorithm;

/**
 * Created by Administrator on 2017/7/6.
 */
public class DFS {

    static  int count = 0;

    /**
     *  题目 给定整数a1,a2,a3…an，判断是否可以从中选出若干数，使他们的和恰好为k
     *  图解地址 ：http://img.blog.csdn.net/20151230111443185
     * @param a 初始输入数组
     * @param i 第i项
     * @param sum 遍历到i项时的和
     * @param k 目标结果
     * @return
     */

    private static boolean defMethod(int[] a, int i, int sum, int k) {
        System.out.println(++count);
        System.out.println( "sum ==" +sum +"    k == " + k);
        //如果已到最后一项，得到和sum，则返回sum是否等于k
        if (i == a.length)
            return sum == k;
        //不加a[i]的情况
        if (defMethod(a, i + 1, sum, k))
            return true;

        //加a[i]的情况
        if (defMethod(a, i + 1, sum + a[i], k))
            return true;
        //无论是否加上a[i]都不能得到k则返回k
        return false;
    }

    public static void main(String[] args) {
        int[] a ={1,2,3,4,5};
        System.out.println(System.currentTimeMillis());
        System.out.println(defMethod(a,0,0,15));
        System.out.println(System.currentTimeMillis());
    }
}
