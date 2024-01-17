class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int conLength=words.length*words[0].length();
        Map<String,Integer> set=new HashMap<>();
        ArrayList<Integer> result=new ArrayList<>();
        for(String word:words){
            if(!set.containsKey(word)){
                set.put(word,1);
            }else{
                set.put(word,set.get(word)+1);
            }
        }
        for(int i=0;i<s.length()-conLength+1;i++){
            Map<String,Integer> set1=new HashMap<>(set);
            String substr=s.substring(i,i+conLength);
            //System.out.println(substr);
            //System.out.println(isItConSub(substr,set1,words[0].length()));
            if(isItConSub(substr,set1,words[0].length())){
                result.add(i);
            }
        }
        return result;
    }



    private boolean isItConSub(String str,Map<String,Integer> mp,int wordLength){
        for(int j=0;j<=str.length()-wordLength;j+=wordLength){
            String sbstr=str.substring(j,j+wordLength);
            //System.out.println(j);
            if(!mp.containsKey(sbstr)){
                return false;
            }else{
                mp.put(sbstr,mp.get(sbstr)-1);
            }
        }
        for(int value:mp.values()){
            if(value!=0){
                return false;
            }
        }
        return true;
    }
}