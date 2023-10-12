//1095. Find in Mountain Array
//https://leetcode.com/problems/find-in-mountain-array/description/
//12-10-2023

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {

        int temp = peakIndexInMountainArray(mountainArr);
        int answer = binarySearch(mountainArr, target, 0, temp, true);

        if(answer != -1) {
            return answer;
        }
        return binarySearch(mountainArr, target, temp, mountainArr.length() - 1, false);
    }

//to find the peak element

    public static int peakIndexInMountainArray (MountainArray arr) {

        int start = 0;
        int end = arr.length() - 1;

        while(start < end) {

            int mid = start + (end - start) / 2;

            if(arr.get(mid) > arr.get(mid + 1)) {

                end = mid;
            }
            else {

                start = mid + 1;
            }

        }
        return start;

    }

//binary search, true is passed, if array in which we are applying
//binary search is in ascending order, else false is passed

    public static int binarySearch (MountainArray arr, int target, int start, int end, boolean isAsc) {

        while(start <= end) {

            int mid = start + (end - start) / 2;

            if(arr.get(mid) == target) {
                return mid;
            }

            if(isAsc) {
                if(arr.get(mid) > target) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            else {

                if(arr.get(mid) < target) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }
}