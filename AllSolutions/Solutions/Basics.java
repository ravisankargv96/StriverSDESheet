package Solutions;

import java.util.*;

public class Basics {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        /**Collections:
         * ArrayList
         * HashMap
         * HashSet
         * Queue
         * PriorityQueue
         * Stack
         * Arrays
         * Strings*/

        ArrayList<Integer> al = new ArrayList<Integer>();
        // inserting
        al.add(1); //[1]
        // inserting at index
        al.add(0,2); //[2,1]
        // deleting
        al.remove(1); //[2]
        // Overwriting
        al.set(0,3); //[3]
        // return element
        al.get(0); // 3
        // converting to array
        al.toArray(); // [3]

        // length
        al.size(); // 1
        // copy
        al.clone(); // [3] -> obj2
        // empty
        al.isEmpty(); // false
        // deleting all the elements.
        al.clear(); // []

        HashMap<String,Integer> hm = new HashMap<String,Integer>();
        // insert
        hm.put("one",1); // {{"one":1}}
        // deleting
        hm.put("zero",0); // {{"one":1},{"zero",0}}
        hm.remove("zero"); // {{"one":1}}
        // return an element
        hm.get("one"); // 1
        // return an element if not present return default one.
        hm.getOrDefault("two",0); // 0
        // find an element
        hm.containsKey("one"); //true
        // getting all the keys
        hm.entrySet(); //{{"one":1}}
        // iteration in hashmap
        for(Map.Entry<String,Integer> entry : hm.entrySet()){
            String key = entry.getKey(); // "one"
            Integer value = entry.getValue(); // 1
        }

        // length
        hm.size(); // 1
        // copy
        hm.clone(); // {{"one":1}}
        // empty
        hm.isEmpty(); // false
        // deleting all the elements
        hm.clear(); // {}

        HashSet<Integer> hs = new HashSet<Integer>();
        // inserting
        hs.add(5); //{5}
        // deleting
        hs.remove(5); //{}
        // find an element
        hs.contains(5);

        // length
        hs.size();
        // copy
        hs.clone();
        // empty
        hs.isEmpty();
        // deleting all the elements
        hs.clear();

        Queue<Integer> queue = new LinkedList<Integer>();
        // inserting
        queue.add(3);
        // removing
        queue.poll();
        // front element
        queue.peek();

        // length
        queue.size();

        // empty
        queue.isEmpty();

        // deleting all the elements
        queue.clear();

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        // inserting
        pq.add(5);
        // removing
        pq.poll();
        // front element
        pq.peek();

        // length
        pq.size();

        // empty
        pq.isEmpty();

        // deleting all the elements
        pq.clear();

        Stack<Integer> st = new Stack<Integer>();
        // inserting
        st.push(10);
        // removing
        st.pop();
        // front element
        st.peek();

        // length
        st.size();
        // copying
        st.clone();
        // empty
        st.isEmpty();
        // deleting all the elements
        st.clear();

    }
}