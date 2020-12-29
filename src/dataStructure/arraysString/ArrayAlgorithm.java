package dataStructure.arraysString;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 배열에서 두개의 숫자를 더해서 타겟 숫자가 되는 숫자 2개의 인덱스를 반환
 */
public class ArrayAlgorithm {

    public static void main(String[] args) throws Exception {

        int[] arr = {6,4,3,8,7,5,2};

        // #1
        int[] result = findTwoIndices(arr, 5);
        System.out.println(Arrays.toString(result));

        // #2
        int[] result2 = findTwoIndices2(arr, 5);
        System.out.println(Arrays.toString(result2));

        // #3
        int[] result3 = findTwoIndices3(arr, 14);
        System.out.println(Arrays.toString(result3));

        int[] result4 = twoSum(arr, 14);
        System.out.println(Arrays.toString(result4));
    }

    // #1
    private static int[] findTwoIndices(int[] arr, int target) throws Exception {

        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] + arr[j] == target){
                    return new int[]{i, j};
                }
            }
        }

        throw new Exception("No two sum exception");
    }

    // #2 hashTable 이용
    private static int[] findTwoIndices2(int[] arr, int target) throws Exception {

        HashMap<Integer, Integer> arrMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            arrMap.put(arr[i], i);
        }
        for(int i = 0; i < arr.length; i++){
            if(arrMap.containsKey(target - arr[i])){
                int i2 = arrMap.get(target - arr[i]);
                if(i != i2) return new int[]{i, i2};
            }
        }
        throw new Exception("No two sum exception");
    }

    // #3 hashTable 이용2 - 초기에 해쉬맵에 값세팅 X
    private static int[] findTwoIndices3(int[] arr, int target) throws Exception {
        HashMap<Integer, Integer> arrMap = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            if(arrMap.containsKey(target - arr[i])){
                return new int[]{i, arrMap.get(target - arr[i])};
            }
            arrMap.put(arr[i], i);
        }

        throw new Exception("No two sum exception");
    }

    public static int[] twoSum(int[] nums, int target) throws Exception {
        HashMap<Integer, Integer> arrMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(arrMap.containsKey(target - nums[i])){
                return new int[]{i, arrMap.get(target - nums[i])};
            }
            arrMap.put(nums[i], i);
        }
        throw new Exception("No two sum exception");
    }

}
