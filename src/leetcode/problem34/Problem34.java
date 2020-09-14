package leetcode.problem34;

class Solution {

    public int binarySearch(int[] nums, int target, int first, int last) {
        int halfIndex = first + (last - first) / 2;
        if ((first == last && nums[first] != target) || last < first) {
            return -1;
        } else if (nums[halfIndex] == target) {
            return halfIndex;
        } else if (nums[halfIndex] < target) {
            return binarySearch(nums, target, halfIndex + 1, last);
        } else if (nums[halfIndex] > target) {
            return binarySearch(nums, target, first, halfIndex - 1);
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {

        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int index = binarySearch(nums, target, 0, nums.length - 1);
        int first = -1;
        int last = -1;
        if (index != -1) {
            first = index;
            last = index;
        } else {
            return new int[]{-1, -1};
        }

        int tempFirst = 0;
        int paramFirst = -1;
        int paramLast = -2;
        while(tempFirst != -1 && (0 != paramLast)) {
            paramLast = first > 0 ? first - 1 : 0;
            tempFirst = binarySearch(nums, target, 0, paramLast);
            if (tempFirst != -1) {
                first = tempFirst;
            }
        }


        int tempLast = 0;
        paramFirst = -1;
        paramLast = -2;
        while(tempLast != -1 && (paramFirst != paramLast)){
            paramFirst = last < nums.length - 1 ? last + 1 : nums.length - 1;
            paramLast = nums.length - 1;
            tempLast = binarySearch(nums, target, paramFirst, paramLast);
            if (tempLast != -1) {
                last = tempLast;
            }
        }



        return new int[]{first, last};
    }

    public void printArr(int[] arr) {
        for(int i : arr) {
            System.out.print(i + ", ");
        }
    }
}

public class Problem34 {

    public static void main(String[] args) {
        Solution s = new Solution();
        // Call method below:

//        int[] arr = new int[]{1,1,1,1,1,1,2,3,4,4,5,5,5,6,7,8,8,8,8};
        int[] arr = new int[]{1,1,1,1,1,1,2,3,4,4,5,5,5,6,7,8,8,8,8};
        int target = 1;

//        System.out.println(s.binarySearch(arr, 1, 0, arr.length - 1));

        s.printArr(s.searchRange(arr, target));

//        0 1 2 3 6 7 8
//

    }
}
