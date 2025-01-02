package LeetCode60Questions.Strings;

public class DecodeString {

    int index = 0;
    public String decodeString(String s) {
        int num = 0;
        StringBuilder str = new StringBuilder();
        for(;index<s.length();index++){
            char c = s.charAt(index);
            if(c=='['){
                index++;
                String restOfString = decodeString(s);
                for(;num>0;num--) str.append(restOfString);
            }else if(Character.isDigit(c)){
                num = num*10 + c-'0';
            }else if(c==']'){
                break;
            }else{
                str.append(c);
            }
        }
        return str.toString();

    }
}
