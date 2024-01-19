class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result=new ArrayList();
        int dir=0;
        int i=0;
        int j=0;
        int m=matrix.length;
        int n=matrix[0].length;
        int nexti=0;
        int nextj=1;
        int count=0;
        boolean back=false;
        while(count<m*n){
            if(dir==0){
                nexti=i;
                nextj=j+1;
            }else if(dir==1){
                nexti=i+1;
                nextj=j;
            }else if(dir==2){
                nexti=i;
                nextj=j-1;
            }else if(dir==3){
                nexti=i-1;
                nextj=j;
            }
            if(i>=0&&i<m&&j>=0&&j<n&&matrix[i][j]!=101){
                result.add(matrix[i][j]);
                matrix[i][j]=101;
                i=nexti;
                j=nextj;
                count++;
                continue;
            }
            if(back){
                if(dir==0){
                    j=j+1;
                }else if(dir==1){
                    i=i+1;
                }else if(dir==2){
                    j=j-1;
                }else if(dir==3){
                    i=i-1;
                }
                back=false;
                continue;
            }
            if(dir==0){
                j=j-1;
            }else if(dir==1){
                i=i-1;
            }else if(dir==2){
                j=j+1;
            }else if(dir==3){
                i=i+1;
            }
            dir=(dir+1)%4;
            back=true;
        }
        return result;
    }
}
