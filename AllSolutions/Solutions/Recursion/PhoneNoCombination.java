package Solutions.Recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class PhoneNoCombination {

    public HashMap<Character,String> createKeyPad(){
        HashMap<Character,String> hm = new HashMap<>();
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");
        return hm;
    }

    //Instead List<Character> v;
    //Use String st itself in representing the state value.
    //For better understanding.
    public void combinations(int pos, String digit,
                             HashMap<Character,String> hm, String st,
                             List<String> ans){
        if(pos == digit.length()){
            ans.add(st);
            return;
        }

        char num = digit.charAt(pos);
        String string = hm.get(num);
        for(int i = 0; i<string.length(); i++){
            char c = string.charAt(i);
            this.combinations(pos+1, digit, hm, st + c , ans);
        }
    }
    public void execute(){
        HashMap<Character,String> hm = this.createKeyPad();
        String digit = "23";
        List<String> ans = new ArrayList<String>();
        String al = "";
        this.combinations(0,digit,hm,al,ans);

        System.out.println(Arrays.deepToString(ans.toArray()));
    }
    public static void main(String[] args){

        PhoneNoCombination phoneNoCombination = new PhoneNoCombination();

        phoneNoCombination.execute();

    }
}
