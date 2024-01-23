class Solution {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length==0){
            return new ArrayList<String>();
        }else if(nums.length==1){
            ArrayList<String> a=new ArrayList();
            a.add(""+nums[0]);
            return a;
        }
        ArrayList<String> list=new ArrayList();
        int ini=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]+1){
                if(ini==nums[i-1]){
                    list.add(""+nums[i-1]);
                }else{
                    list.add(ini+"->"+nums[i-1]);
                }
                ini=nums[i];
            }
            if(i==nums.length-1){
                if(ini==nums[i]){
                    list.add(""+nums[i]);
                }else{
                    list.add(ini+"->"+nums[i]);
                }
            }
        }
        return list;
    }
}