import java.util.ArrayList;
import java.util.List;

public class DPSolutions {
    //Climbing Stairs
    public int climbStairs(int n) {
        if (n==1 || n==2 || n==3)
            return n;
        int a=1, b=2, c=3;
        for (int i=4; i<=n; i++) {
            a=b;
            b=c;
            c=a+b;
        }
        return c;
    }

    //Pascal's Triangle
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<numRows; i++) {
            List<Integer> triangleRow = new ArrayList<>();
            triangleRow.add(1);
            for (int j=1; j<i; j++) {
                triangleRow.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
            }
            if (i>0)
                triangleRow.add(1);
            result.add(triangleRow);
        }
        return result;
    }

    //Jump Game, better DP solution (O(n) time, O(1) space)
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i=0; i<nums.length; i++) {
            if (i>maxReach)
                return false;
            maxReach=Math.max(maxReach, i+nums[i]);
        }
        return true;
    }

}
