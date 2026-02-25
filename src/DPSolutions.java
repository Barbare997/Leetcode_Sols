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

}
