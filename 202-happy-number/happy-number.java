class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer>set=new HashSet<>();
        while(set.add(n)){
            int sum=0;
            while(n>0){
                int d=n%10;
                n=n/10;
                sum+=d*d;
            }
            if(sum==1){
                return true;
            }
            n=sum;
        }
        return false;
    }
}