class Solution {

    public String minWindow(String s, String t) {
        if(s==null||t==null||s.isEmpty()||t.isEmpty()){
            return "";
        }
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<t.length();i++){
            if(!map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),1);
            }else{
                map.put(t.charAt(i),map.get(t.charAt(i))+1);
            }
        }

        int i=0;
        int j=0;
        int left=0;
        int right=0;
        int count=map.size();
        int minlen=s.length();
        boolean found=false;
        while(j<s.length()){
            char endChar=s.charAt(j++);
            if(map.containsKey(endChar)){
                map.put(endChar,map.get(endChar)-1);
                if(map.get(endChar)==0){
                    count--;
                }
            }
            if(count>0){
                continue;
            }
            while(count==0){
                char starChar=s.charAt(i++);
                if(map.containsKey(starChar)){
                    map.put(starChar,map.get(starChar)+1);
                    if(map.get(starChar)>0){
                        count++;
                    }
                }
            }
            if(j-i+1<=minlen){
                found=true;
                left=i-1;
                right=j-1;
                minlen=j-i+1;
            }
        }
        if(!found){
                return "";
            }else{
                return s.substring(left,right+1);
            }
    }
}
    
