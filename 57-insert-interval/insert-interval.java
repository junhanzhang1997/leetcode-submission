class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0){
            return new int[][]{ newInterval };
        }
        int a=newInterval[0];
        int b=newInterval[1];
        List<int[]> lst=new ArrayList<>();
        boolean added=false;
        for(int i=0;i<intervals.length;i++){
            if(b<intervals[i][0]){
                if(!added){
                    lst.add(new int[]{a,b});
                    added=true;
                }
                lst.add(intervals[i]);
            }else if(a<intervals[i][0]&&b>=intervals[i][0]&&b<=intervals[i][1]){
                b=intervals[i][1];
                lst.add(new int[]{a,b});
                added=true;
            }else if(a<intervals[i][0]&&b>=intervals[i][0]&&b>intervals[i][1]){
                if(i==intervals.length-1){
                    lst.add(new int[]{a,b});
                }
            }else if(a>=intervals[i][0]&&a<=intervals[i][1]){
                a=Math.min(a,intervals[i][0]);
                if(b<=intervals[i][1]){
                    lst.add(new int[]{a,intervals[i][1]});
                    added=true;
                }else if(i==intervals.length-1){
                    lst.add(new int[]{a,b});
                }
            }else if(a==intervals[i][1]){
                a=intervals[i][0];
                if(i==intervals.length-1){
                    lst.add(new int[]{a,b});
                }
            }else if(a>intervals[i][1]){
                lst.add(intervals[i]);
                if(i==intervals.length-1){
                    lst.add(new int[]{a,b});
                }
            }
        }
        return lst.toArray(new int[lst.size()][]);
    }
}