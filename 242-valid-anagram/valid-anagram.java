class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer>mapS=new HashMap<>();
        HashMap<Character,Integer>mapT=new HashMap<>();
        if(s.length()!=t.length()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            char cs=s.charAt(i);
            char ct=t.charAt(i);
            if(!mapS.containsKey(cs)){
                mapS.put(cs,1);
            }else{
                mapS.put(cs,mapS.get(cs)+1);
            }
            if(!mapT.containsKey(ct)){
                mapT.put(ct,1);
            }else{
                mapT.put(ct,mapT.get(ct)+1);
            }
        }
        if(mapS.equals(mapT)){
            return true;
        }
        return false;
    }
}