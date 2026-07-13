class Solution {
    public int firstMissingPositive(int[] nums) {
        int n =nums.length;
        int i=0;
        while(i<n){
            int idx=nums[i]-1;
            if(nums[i]>0 && nums[i]<=n && nums[i]!=nums[idx]){
                swap(nums,i,idx);
            }
            else{
                i++;
            }

        }
        for(int k=0;k<n;k++){
            if(k!=nums[k]-1)
            return k+1;
        }
        return n+1;

        
    }
    private void swap(int []arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;


    }
}