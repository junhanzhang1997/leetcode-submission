class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> mag=new HashMap<>();
        for(int i=0;i<magazine.length();i++){
            char c=magazine.charAt(i);
            if(!mag.containsKey(c)){
                mag.put(c,1);
            }else{
                mag.put(c,mag.get(c)+1);
            }
        }
        for(int i=0;i<ransomNote.length();i++){
            char c=ransomNote.charAt(i);
            if(mag.containsKey(c)&&mag.get(c)>0){
                mag.put(c,mag.get(c)-1);
            }else{
                return false;
            }
        }
        return true;
    }
}