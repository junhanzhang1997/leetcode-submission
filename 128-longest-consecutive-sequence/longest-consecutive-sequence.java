class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int count=1;
        int currCount=1;
        int preV=nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==preV+1){
                currCount++;
            }else if(nums[i]!=preV){
                currCount=1;
            }
            if(currCount>count){
                count=currCount;
            }
            preV=nums[i];
        }
        return count;
    }
}