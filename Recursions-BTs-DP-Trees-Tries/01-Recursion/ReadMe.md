# Completed Codes


1. SubsetsI
2. SubsetsSum
3. SubsetsII
4. CombinationSumI
5. CombinationSumII
6. PermutationsI
7. PermutationsII


## Todo
1. Dynamic Programming Subset Sum
2. Kth Permutation
3. Palindromic Partitions
4. Word Break
5. Word Break2
6. Letter Combinations of a phone number


## Generalization

Subset
```
								f(0, [])
								   /  \
                           f(1, [a0]) f(1, [])
```
`base condition:`
```
f(len(arr), [a0, a2, an-1])
```

Permutations: