class Solution {
    public void sortColors(int[] nums) {
        bubbleSort(nums); 
        
    }
    
    public static void bubbleSort(int[] nums) {
        for(int i=0; i<nums.length; ++i) {
            for(int j=0; j<nums.length-i-1; ++j) {
                if(nums[j] > nums[j+1]) {
                    swap(nums, j, j+1);
                }
            }
        }
    }
    
    public static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}