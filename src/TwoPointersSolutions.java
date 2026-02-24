public class TwoPointersSolutions {
    //Remove Duplicates from Sorted Array
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i=1; i<nums.length; i++) {
            if (nums[i]!=nums[i-1]) {
                k++;
                nums[k] = nums[i];
            }
        }
        return k+1;
    }

    //Move Zeroes
    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i]!=0) {
                nums[k] = nums[i];
                k++;
            }
        }
        for (int i=k; i<nums.length; i++){
            nums[i] = 0;
        }
    }

    //Merge Sorted Array
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int firstPointer = m-1;
        int secondPointer = n-1;
        int bothPointer = nums1.length - 1;
        while (firstPointer>=0 && secondPointer>=0 && bothPointer>=0){
            if (nums1[firstPointer]>nums2[secondPointer]){
                nums1[bothPointer] = nums1[firstPointer];
                firstPointer--;
            } else {
                nums1[bothPointer] = nums2[secondPointer];
                secondPointer--;
            }
            bothPointer--;
        }
        for (int i = secondPointer; i>=0; i--){
            nums1[bothPointer] = nums2[i];
            bothPointer--;
        }
    }
}
