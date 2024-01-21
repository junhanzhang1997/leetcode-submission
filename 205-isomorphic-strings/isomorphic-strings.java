/*class Solution {
    public boolean isIsomorphic(String s, String t) {
        int l=s.length();
        HashMap<Character,Character> map=new HashMap<>();
        for(int i=0;i<l;i++){
            char ss=s.charAt(i);
            char tt=t.charAt(i);
            if(map.containsKey(ss)&&map.get(ss)!=tt||
            map.containsKey(tt)&&map.get(tt)!=ss){
                return false;
            
            }
            map.put(ss,tt);
            map.put(tt,ss);
        }
        return true;
    }
}
*/
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        int n = s.length() - 1;
        
        while (n >= 0) {
            if (map.containsKey(s.charAt(n)) && map.get(s.charAt(n)) != t.charAt(n)) {
                return false;
            }
            if (!map.containsKey(s.charAt(n)) && set.contains(t.charAt(n))) {
                return false;
            }
            set.add(t.charAt(n));
            map.put(s.charAt(n), t.charAt(n));
            n--;
        }
        
        return true;
    }
}
