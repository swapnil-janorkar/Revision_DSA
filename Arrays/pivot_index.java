class Solution {
    public int pivotIndex(int[] nums) {
        int ans =-1; 
        int[]pf =new int[nums.length];
        pf[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            pf[i]=pf[i-1]+nums[i];
        }
        
        if(pf[0]==(pf[nums.length-1])){
            return 0;
        }
        for(int i=1;i<nums.length;i++){
            if(pf[i-1]==(pf[nums.length-1]-pf[i])){
                return i;
            }
        }
        return ans ;
        
    }
}