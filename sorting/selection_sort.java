class Solution {
    public int[] sortArray(int[] nums) {
        int n =nums.length;
        for(int i=0;i<n-1;i++){
            int minidx=i;
            for(int j=i+1;j<n;j++){
                if(nums[j]<nums[i]){
                    minidx=j;
                }
                int temp=nums[i];
                nums[i]=nums[minidx];
                nums[minidx]=temp;
                
            }
        }
        return nums;
        
    }
}