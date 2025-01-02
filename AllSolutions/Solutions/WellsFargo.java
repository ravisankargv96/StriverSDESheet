package Solutions;

import java.util.*;

public class WellsFargo {

    public boolean func(int rem, ArrayList<Integer> al, int count,int[] ans){
        //base condition
        if(rem == 1 || rem == 2 || rem == 3){

            ans[0] = count + 1;
            return true;
        }

        for(int i = al.size()-1; i >= 0; i--){

            if(rem - al.get(i) >= 0){

                boolean depth = func(rem - al.get(i), al, count+1,ans);
                if(depth){
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        ArrayList<Integer> deno = new ArrayList<>();

        int value = 1;
        for(int i = 2; i<= 30; i += 2){
            value *= 2*2;
            deno.add(value);
        }

        int[] arr = new int[]{12,3,7,8,15,19};

        WellsFargo obj = new WellsFargo();

        ArrayList<Integer> res = new ArrayList<>();

        int n = arr.length;

        for(int i = 0; i<n; i++){

            int[] ans = new int[]{0};

            boolean isPossible = obj.func(arr[i],deno,0,ans);

            if(isPossible){
                res.add(ans[0]);
            } else{
                res.add(-1);
            }
        }

        System.out.println(res);
    }
}
