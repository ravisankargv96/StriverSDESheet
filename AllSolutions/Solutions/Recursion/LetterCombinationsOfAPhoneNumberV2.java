package Solutions.Recursion;

import java.util.*;

public class LetterCombinationsOfAPhoneNumberV2 {
    // first create a hashmap to map the character set with their unique string Eg : 2 -> abc
    HashMap<Character,String> map = new HashMap<>(){{
        put('2',"abc");
        put('3',"def");
        put('4',"ghi");
        put('5',"jkl");
        put('6',"mno");
        put('7',"pqrs");
        put('8',"tuv");
        put('9',"wxyz");
    }};// declaration and initialization of map
    char[] arr;
    List<String> result = new ArrayList<>();// result list
    public List<String> letterCombinations(String digits) {
        //Base condition
        if(digits.length() == 0){
            return result;
        }
        this.arr = digits.toCharArray(); // converts string to character array
        dfs(0,new ArrayList<>());
        return result;
    }
    private void dfs(int start,List<Character> sub){
        //When to append to result
        if(start == arr.length){
            //result.add(new ArrayList<>(sub));
            convertToString(new ArrayList<>(sub));
            return;
        }
        String str = map.get(arr[start]);
        for(char curr : str.toCharArray()){
            sub.add(curr);
            dfs(start+1,sub);
            sub.remove(sub.size()-1);
        }
    }
    private void convertToString(List<Character> sub){
        StringBuilder sb = new StringBuilder();
        for(Character c : sub){
            sb.append(c);
        }
        result.add(sb.toString());
    }
}