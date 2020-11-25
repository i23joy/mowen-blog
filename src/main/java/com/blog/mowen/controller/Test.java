package com.blog.mowen.controller;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,3};
        int i = removeDuplicates(nums);
        System.out.println(i);
    }

    private static int removeDuplicates(int[] nums) {
        int cursor1 = 0;
        int cursor2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[cursor1] == nums[cursor2] && cursor2 <= i) {
                cursor2++;
            }else {
                int temp = nums[cursor2];
                nums[cursor2] = nums[cursor1++];
                nums[cursor1] = temp;
            }
        }
        System.out.println(nums.toString());
        return cursor1;
    }

}
