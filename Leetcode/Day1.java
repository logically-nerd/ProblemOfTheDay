//https://leetcode.com/problems/max-dot-product-of-two-subsequences/?envType=daily-question&envId=2023-10-08
//1458. Max Dot Product of Two Subsequences
//8-10-2023

class Solution {
    // using dp
    int[][] temp;

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int num : nums1) {
            max1 = Math.max(max1, num);
            min1 = Math.min(min1, num);
        }
        for (int num : nums2) {
            max2 = Math.max(max2, num);
            min2 = Math.min(min2, num);
        }

        // if max element of any array is negative and min element of other array is
        // positive
        // it'll give negative as the best result
        // our dp method will give 0 if this case arises
        // but question want us to give a maximum value not just positive
        // therefore we will return the best negative value

        if (max1 < 0 && min2 > 0) {
            return max1 * min2;
        }
        if (max2 < 0 && min1 > 0) {
            return max2 * min1;
        }
        // else initialize the matrix and call the dp method
        temp = new int[nums1.length][nums2.length];
        return maxProd(0, 0, nums1, nums2);
    }

    int maxProd(int i, int j, int[] nums1, int[] nums2) {
        if (i == nums1.length || j == nums2.length) {
            // base case
            // when either of the one array ends
            return 0;
        }
        if (temp[i][j] != 0) {
            return temp[i][j];
        }
        int prod = nums1[i] * nums2[j] + maxProd(i + 1, j + 1, nums1, nums2);
        // if number at i and j is multiplied

        // else i is multiplied with j+1
        // or j is multiplied with i+1
        // and max of the three situation is stored as cache
        temp[i][j] = Math.max(prod, Math.max(maxProd(i, j + 1, nums1, nums2), maxProd(i + 1, j, nums1, nums2)));
        return temp[i][j];
    }
}