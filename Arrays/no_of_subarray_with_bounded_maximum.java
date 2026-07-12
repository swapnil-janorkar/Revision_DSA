class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int ans=0;
        int lgi = 0;
        int pvc=0;
        for(int ep=0;ep<nums.length;ep++){
            if(nums[ep]>right){
                lgi=ep+1;
                ans+=0;
                pvc=0;
            }
            else if(nums[ep]>=left && nums[ep]<=right){
                ans+=(ep-lgi+1);
                pvc=(ep-lgi+1);
            }
            else if(nums[ep]<left){
                ans+=pvc;
            }
        }
        return ans;
    }
}