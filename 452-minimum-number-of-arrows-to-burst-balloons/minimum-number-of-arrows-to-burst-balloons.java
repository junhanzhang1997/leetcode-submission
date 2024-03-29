class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,Comparator.comparingInt(a->a[0]));
        int total=1;
        int[]prev=points[0];
        for(int i=1;i<points.length;i++){
            if(points[i][0]>prev[1]){
                total++;
                prev=points[i];
            }else{
                prev[1]=Math.min(prev[1],points[i][1]);
            }
        }      
        return total;     
    }
}