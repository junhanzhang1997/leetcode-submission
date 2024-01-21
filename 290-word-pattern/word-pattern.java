class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words=s.split(" ");
        int plen=pattern.length();
        int slen=words.length;
        HashMap<Character,String> map=new HashMap<>();
        HashMap<String,Character> map2=new HashMap<>();
        if(plen!=slen){
            return false;
        }

        for(int i=0;i<plen;i++){
            char c=pattern.charAt(i);
            String word=words[i];
            if(map.containsKey(c)&&!map.get(c).equals(word)||
            map2.containsKey(word)&&!map2.get(word).equals(c)){
                
                return false;
            }
            map.put(c,word);
            map2.put(word,c);
        }
        return true;
    }
}