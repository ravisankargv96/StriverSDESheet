1. SummationPrinting
                -> Summation
                -> a*r^k

2. TwoPointer   -> twoPointerWithoutDuplicates(int[], int);
                -> twoPointerWithDuplicates(int[],target);
                -> twoPointerInwards(int[]);
                -> twoPointerOutwards(int[]);
                -> DNFSort(int[]);

                -> if possible add LinkedList fast & slow pointer here.


3. BinarySearch -> BinarySearch(int[],int);
                -> searchFirstPos(int[],int);
                -> searchLastPos(int[],int);
                -> searchInsertPosition(int[],int);
                -> findPeakElement(int[]); -> Bitonic array
                -> rotatedSortedArray(int[],int); -> pending
                -> Sqrt(x)


4. Sorting      -> Insertion
                -> MergeSort
                -> QuickSort


5. Sliding Window
There are 5 problems that comes under this pattern (see later)


7. Recursion.Recursion
        2 Branches:
                -> LeftRootRight(int); - Basic version
                -> LeftRootRight(String,int,List<String>); - Sequence pattern
                -> LeftRootRight(ArrayList<Character>,int,List<ArrayList<Character>>); - sequence pattern
                -> generateParanthesis(String,int,...);
                -> generateParanthesis(ArrayList<Character>,int,...);
                -> subsequence(int[],String,int,...);
                -> subsequence(int[],ArrayList<Character>,int,...);

        Binary Trees:
                -> LeftRootRight(int); - Basic version
                -> validateBST();
                -> hasPathSum();
                -> BTInOrderPostOrder();
                -> SortedArrayToBST();
                -> minimumDepthOfBT();
                -> BTMaximumPathSum();
                -> balancedBT();
                -> isSymmetric();

        n Branches:
                -> Permutations();
                -> PermutationsWithRepInput();


6. Linked List (Do later)
                ->
Add back tracking problems also all the backtracking are n-ary trees itself.

Have a look of these problems: https://github.com/imkgarg/Awesome-Software-Engineering-Interview/blob/master/Coding.md
Which covered problems under this pattern.

Topics from revision guide:

* LinkedList
    - reverse Linked List (Iterative, Recursive)
        * Palindrome linked list
        * Swap Nodes in pair in linked list
        * Reverse a Linked list in group of size k

    - merging Linked List
        * Merge two sorted linked list
        * Merge K Sorted Lists

    - length
    - middle Element In Linked List

    - Fast & Slow pointer
        * Detect a cycle in Linked List
        * Find the starting point of loop of linked list

    - Offset pointer
        * Remove Nth Node from back of the linked list

    problems:
        * Intersection point of Y linked list.
        * Add two numbers as linked list
        * Flattening a linked list
        * Clone a linked list with next and random pointer
        * LRU Cache

* Sliding Window
* Stack
    - nextGreaterElement
* Math
    - GCD
    - isPrime

* Bit Manipulation
    - iterating Through Bits

* Binary Search

* Recursion
    * Trees

    - Formula based
        - pow(x,n)
    - permutations without Reps
    - permutations with Reps

* Backtracking

* BFS, DFS
    - Template of BFS, DFS

    - Matrix Traversal
    - Graph Traversal
    - Tree Traversal
* Dynamic Programming

* Trees
* Graphs
    - edgesToAdjacencyMatrix
    - Topological Sorting

* Greedy Algorithms
* Priority Queue
* Tries
