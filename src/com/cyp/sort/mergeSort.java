package com.cyp.sort;

/**
 * 合并排序算法
 *
 * 参考文档 ：http://blog.jobbole.com/55184/
 */
public class mergeSort {

    public  static  String test = "flkadsjf;lasdj f[paesfg[oa s:)weixiaohfpods发的说法";

    public static void main(String[] args) {
        char[] rightArray = test.toCharArray();
        System.out.println(System.currentTimeMillis());
        char[] array = mergeSort(rightArray);
        System.out.println(array);
        System.out.println(System.currentTimeMillis());
    }


    public static char[] mergeSort(char[] array) {
        if(array.length ==1)
            return array;
        int middleNum = array.length/2;
        char[] leftArray = new char[middleNum];
        char[] rightArray= new char[array.length-middleNum];
        split_into_2_equally_sized_arrays(array,leftArray,rightArray);
        leftArray = mergeSort(leftArray);
        rightArray = mergeSort(rightArray);
        return merge(leftArray,rightArray);
    }

    public static char[] merge(char[] leftArray, char[] rightArray) {
        char result[] = new char[leftArray.length + rightArray.length];
        int i = 0, j = 0;
        char leftHead = leftArray[i], rightHead = rightArray[j];

        for (int m = 0; m < result.length; m++) {
            if (leftHead < rightHead) {
                result[m] = leftHead;
                i++;
                if(i<leftArray.length){
                    leftHead = leftArray[i];
                    continue;
                }else {
                    leftHead=(char)-1;
                }
            } else {
                result[m] = rightHead;
                j++;
                if(j<rightArray.length){
                    rightHead = rightArray[j];
                    continue;
                }else {
                    rightHead=(char)-1;
                }
            }
        }

        return result;
    }

    public  static  void split_into_2_equally_sized_arrays (char[] src,char[] leftArray,char[] rightArray){
        for(int i=0;i<leftArray.length;i++){
            leftArray[i]=src[i];
        }
        for(int m=0,j=leftArray.length;j<src.length;j++,m++){
            rightArray[m] = src[j];
        }
    }


}
