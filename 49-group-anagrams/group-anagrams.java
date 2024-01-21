class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>>map =new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String word=strs[i];
            char[]chars=word.toCharArray();
            Arrays.sort(chars);
            String sortedW=new String (chars);

            if(!map.containsKey(sortedW)){
                ArrayList<String> list=new ArrayList<>();
                list.add(word);
                map.put(sortedW,list);
            }else{
                ArrayList<String> list=map.get(sortedW);
                list.add(word);
                map.put(sortedW,list);
            }
        }
        return new ArrayList<>(map.values());
    }
}