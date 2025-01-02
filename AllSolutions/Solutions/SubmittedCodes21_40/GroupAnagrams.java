package SubmittedCodes21_40;

import java.util.*;

public class GroupAnagrams {

    public String getHash(String string){

        String key = "";

        int[] charArray = new int[26];

        for(int i = 0; i<charArray.length; i++){
            charArray[i] = 0;
        }

        int n = string.length();

        for(int i = 0; i<n; i++){
            char c = string.charAt(i);
            charArray[c-'a']++;
        }

        for(int i = 0; i<charArray.length; i++){
            key += "#" + Integer.toString(charArray[i]);
        }

        return key;
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<>();

        Map<String,List<String>> hm = new HashMap<>();

        for(String string: strs){

            String key = this.getHash(string);

            if(!hm.containsKey(key)){

                hm.put(key,new ArrayList<>());

            }

            hm.get(key).add(string);
        }

        for(Map.Entry<String,List<String>> entry:hm.entrySet()){
            res.add(entry.getValue());
        }

        return res;

    }

}
