class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(i>k){
                set.remove(nums[i-1-k]);
            }
            if(!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}