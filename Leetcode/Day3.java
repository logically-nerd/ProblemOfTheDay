//2009. Minimum Number of Operations to Make Array Continuous
//https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/?envType=daily-question&envId=2023-10-10
//10-10-2023

//can be further optimise
class Solution {
    public int minOperations(int[] nums) {
        // max-min==nums.length-1 => it has to be continunous
        if (nums.length < 2) {
            return 0;
        }
        // optimize the set section
        SortedSet<Integer> set = new TreeSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int top = set.size();
        int i = 0;
        for (int element : set) {
            nums[i++] = element;
        }
        int maxSelection = 0;
        //uses sliding window technique
        for (int min = 0, j = min + 1; min < top && j < top; min++) {
            int range = nums[min] + nums.length - 1;
            while (j < top && nums[j] <= range) {
                j++;
            }
            maxSelection = Math.max(maxSelection, j - min);
        }
        return nums.length - maxSelection;
    }
}