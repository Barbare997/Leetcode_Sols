import java.lang.reflect.Array;
import java.util.Arrays;

public class Greedy {
    //Minimum Number of Moves to Seat Everyone
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int result=0;
        for (int i=0; i<seats.length; i++)
            result+=Math.abs(seats[i]-students[i]);
        return result;
    }


    //Minimum Operations to Make the Array Increasing
    public int minOperations(int[] nums) {
        int result =0;
        for (int i=1; i<nums.length; i++) {
            int x =Math.max(0, nums[i-1]-nums[i]+1);
            nums[i]+=x;
            result+=x;
        }
        return result;
    }
}
