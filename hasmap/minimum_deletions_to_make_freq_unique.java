import java.util.*;
class Solution {
    public int minDeletions(String s) {
        int n=s.length();
        HashMap<Character,Integer>hm=new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);

        };
        int del=0;
        HashSet<Integer>hs=new HashSet<>();
        for(int x: hm.values()){
            while(x>0 && hs.contains(x)){
                x--;
                del++;
            }
            if(x>0){
                hs.add(x);
            }
        }
        return del;
        
        
        
    }
}