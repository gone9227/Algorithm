package algorithm.leetCode;

import java.util.Arrays;

/**
 * 4. Median of Two Sorted Arrays
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class MedianTwoArrays {
    public static void main(String[] args){
        // case1
//        int[] nums1 = {1, 3};
//        int[] nums2 = {2};
        // case2
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        // case3
//        int[] nums1 = {};
//        int[] nums2 = {1};
        // case3
//        int[] nums1 = {1, 3};
//        int[] nums2 = {2, 7};


        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = 0;
        int[] allNums = new int[nums1.length + nums2.length];
        int len = allNums.length;

        for(int i = 0; i < nums1.length; i++){
            allNums[i] = nums1[i];
        }

        for(int i = 0; i < nums2.length; i++){
            allNums[i + nums1.length] = nums2[i];
        }
        Arrays.sort(allNums);
        System.out.println(Arrays.toString(allNums));
        if(len % 2 == 0){
            return (allNums[len / 2 - 1] + allNums[len / 2]) / 2.0;
        }else {
            return allNums[len / 2];
        }
    }
}

/*
*
* 다른 사람 해결법을 보니 Binary Search 로 푼 사례들이 있었다.
* 이진 탐색에 익숙해지기 위해 기본 문제를 달달 외울때까지 풀어봐야 할 듯.
*
* */