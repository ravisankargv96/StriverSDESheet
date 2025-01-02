package LeetCode_copies.SubmittedCodes1_20;


//This approach is all about going to the centre of a substring & check the left & right of the substring.
//This centre can be a char as well as space b/w two characters.
//Hence, traversing towards left & right of the substring yields us the palindromic string.
//Now, we just have to find the largest possible string amongst the palindromic substrings.
//
//Time Complexity : O(n^2)
//Space Complexity: O(1)

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {

        if(s.length() == 1){
            return s;
        }

        int n= s.length();
        int count= 0;

        StringBuilder result= new StringBuilder();

        for(int i= 1; i<n; i++){
            String odd= oddString(i, s);
            String even = evenString(i, s);

            int newLength= Math.max( odd.length(), even.length() );

            if( result.length() < newLength){

                if(odd.length() > even.length()){
                    result= new StringBuilder(odd);
                }
                else{
                    result= new StringBuilder(even);
                }

            }

            //  If the palindromic substring is of length == s.length(), then we can say that no palindromic substring can be greater than it.
            //  Hence we just return from here.
            if(result.length() == s.length()){
                return result.toString();
            }
        }

        if(result.toString().equals("")){
            return s.substring(0, 1);
        }
        else{
            return result.toString();
        }
    }

    //  Check palindrome string

    //  For palindromic string of odd length (eg: bab)
    public String oddString(int a, String s){
        int left= a-1;
        int right= a+1;

        int n= s.length();

        String result= "";

        while(left >=0 && right <n ){
            if(s.charAt(left) == s.charAt(right)){
                result= s.substring(left, right+1);
                left--;
                right++;
            }
            else{
                return result;
            }
        }

        return result;
    }

    //  For palindromic string of even length (eg: bb)
    public String evenString(int a, String s){
        int left= a-1;
        int right= a;

        int n= s.length();

        String result= "";

        while(left >=0 && right<n){
            if(s.charAt(left) == s.charAt(right)){
                result= s.substring(left, right+1);
                left--;
                right++;
            }

            else{
                return result;
            }
        }
        return result;
    }
}
