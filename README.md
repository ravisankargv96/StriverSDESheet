# StriverSDESheet
Complete all the 181 Striver SDE Sheet problems from bruteforce to Optimal solutions


MySolutions: (obsidian Articles)
	1. Arrays
	
Articles: (gfg / techieDelight / Striver)
	1. Arrays
	2. Linked List
	3. Recursion 
	4. Recursion & BackTracking
	5. Dynamic Programming
	6. Binary Trees 
	7. Binary Search Trees


Python (Recursion):
	1. Recursion
	2. Recursion & BackTracking
	3. Dynamic Programming
	4. Binary Trees
	5. Binary Search Trees

Java (All Solutions)
	1. Linked List
	2. Recursion
	3. Recursion & BackTracking
	4. Dynamic Programming
	5. Binary Trees
	6. Binary Search Trees

## Helper Methods/Patterns
1. Linked List 
	- Length of linked list (H)
	- Reverse Linked List (Iterative & Recursive)
	- Middle Element (BruteForce & Two Pointer)
	- Detect a Cycle (BruteForce & Slow-Fast Pointer)
	- Finding Element at Nth Position (Two Pointer Approach)
	- Merging Algo
		- Both Pointer Stays in loop
		- Any One Pointer Stays in loop
2. Recursion (Templates)	  
	- All the children have same amount of branches ($n-ary$ )
		- Use CurrState Vector
		- Use of Variable
		- Problems
			- SubSets, 
			- Permutation
	- All children have same amount of branches ($n-ary$), but some are pruned.
		- Matrix Traversals across n directions `pruned by visited array` 
		- Sudoko Solver `pruned by not valid`
		- Generate Parenthesis `pruned: )( invalid case`
	- All the children have different amount of branches $i \in (idx, len)$ 
		- Eg. Palindrome Partitioning
3. BinaryTrees (Templates)
	- DFS
	- BFS
		