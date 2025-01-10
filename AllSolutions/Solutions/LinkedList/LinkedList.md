Index of Problems

| Sno | Description                                                  | Type              | Codes | Articles |
| --- | ------------------------------------------------------------ | ----------------- | ----- | -------- |
| 1   | Reverse a Linked List                                        | Algo              | [x]   | [x]      |
| 2   | Find the middle of Linked List                               | Algo              | [x]   | [x]      |
| 3   | Merge two sorted Linked List                                 | Algo              | [x]   | [x]      |
| 4   | Add two numbers as Linked List                               | Application Based | [x]   | [x]      |
| 5   | Remove Nth node from back of Linked List                     | Algo              | [x]   | [x]      |
| 6   | Delete a given Node when a node is given (**O(1) solution**) | Memory            | [x]   | [x]      |
|     |                                                              |                   |       |          |
| 7   | Find intersection point of Y Linked List                     | Standard          | [x]   | [x]      |
| 8   | Detect a cycle in Linked List                                | Standard          | []    | [x]      |
| 9   | Find the starting point of the loop of linked list           | Application       | []    | [x]      |
| 10  | Flattening of a linked list                                  | Application       | []    | [x]      |
| 11  | Reverse a Linked List in groups of size k.                   | Application       | []    | [x]      |
| 12  | Check if a Linked List is **palindrome** or not              | Application       | [x]   | [x]      |
|     |                                                              |                   |       |          |
| 13  | Rotate a Linked List                                         | Application       | []    | [x]      |
| 14  | Clone a Linked List with random & next pointer               | Application       | []    | [x]      |
| 15  | LRU Cache                                                    | Algo              | []    | [x]      |


## Algos & Helper
1. Reverse a linked list
2. fast & slow pointer
3. floyd warshall Algo to find starting point in linked list loop. (proof)
4. Merging two sorted linked lists
5. Finding Nth node from end (idea/Algo)
	1. Add a dummy node, move the fast pointer k steps.
	2. To reach fast pointer to n-1th location it should increment (n-1) - (k) steps.
	3. Then slowpointer is at n-1-k i.e. (n-k)-1th position, there for the next element is (n-k)th one.