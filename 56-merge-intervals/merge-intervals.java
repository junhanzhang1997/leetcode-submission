class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));

        List<int[]> lst=new ArrayList<>();
        int ini=intervals[0][0];
        int end=intervals[0][1]; 

        for(int i=0;i<intervals.length;i++){
            if(i==intervals.length-1){
                lst.add(new int[]{ini,end});
            }else if(intervals[i+1][0]<=end){
                end=Math.max(end,intervals[i+1][1]);
            }else{
                lst.add(new int[]{ini,end});
                ini=intervals[i+1][0];
                end=intervals[i+1][1];
            }
        }
        return lst.toArray(new int[lst.size()][]);
    }
}