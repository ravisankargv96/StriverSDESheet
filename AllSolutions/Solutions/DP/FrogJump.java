package Solutions.DP;

public class FrogJump {

    // Recursive Approach
    public static int frogJump(int ind, int[] height) {
        if (ind == 0) {
            return 0;
        }

        if (ind == 1) {
            return Math.abs(height[1] - height[0]);
        }

        int left = Math.abs(height[ind] - height[ind - 1]) + frogJump(ind - 1, height);

        int right = Math.abs(height[ind] - height[ind - 2]) + frogJump(ind - 2, height);

        return Math.min(left, right);
    }

    public static void main(String[] args) {
        // Example usage:
        int[] height = { /* Your array of heights here */ };
        int result = frogJump(height.length - 1, height);
        System.out.println("Minimum cost: " + result);
    }
}

