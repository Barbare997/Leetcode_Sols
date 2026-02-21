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
}
