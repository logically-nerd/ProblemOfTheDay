//34. Find First and Last Position of Element in Sorted Array
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/?envType=daily-question&envId=2023-10-09
//9-10-2023

class Solution {
    public int[] searchRange(int[] nums, int target) {
        //using binary search
        int[] ans={-1,-1};
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>=target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        if(low<nums.length && nums[low]==target){
            //if the target is in the array
            //and low point the target
            ans[0]=low;
        }
        low=0;
        high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]<=target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        if(high>=0 && nums[high]==target){
            ans[1]=high;
        }
        return ans;
    }
}