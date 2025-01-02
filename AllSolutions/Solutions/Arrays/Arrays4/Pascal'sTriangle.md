# Pascal's Triangle
Given an integer `numRows`, return the first numRows of **Pascal's Triangle.**

In Pascal's Triangle, each number is the sum of the two numbers directly above it as shown:

## Example 1:
```
Input: numRows = 5
Output:
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1
```

## Example 2:
```
Input: numRows = 1
Output:
1
```

## Constraints:

- 1 <= numRows <= 30

### Solution:

```
class Solution {
    public List<List<Integer>> generate(int numRows) {
```
Initializing 2D result array
```
        List<List<Integer>> triangle = new ArrayList<>();

```
base case
```
        if (numRows == 0) return triangle;

        // Generate each row of Pascal's Triangle

```
triangle[i][0] = 1
triangle[i][j] = triangle[i-1][j] + triangle[i-1][j-1]
triangle[i][i] = 1
```
        for(int i = 0; i < numRows; i++){
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < i+1; j++){
                
                // First & Last elements are always 1
                if (j == 0 || j == i){
                    row.add(1);
                } else{
                    int val = triangle.get(i - 1).get(j) + triangle.get(i-1).get(j - 1);
                    row.add(val);
                }
                
            }
            triangle.add(row);
        }

        return triangle;

    }
}
```
