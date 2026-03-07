import java.util.Arrays;

public class Sorting {
    //H-Index
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int cnt=0;
        for (int i=citations.length-1; i>=0; i--) {
            if (citations[i]>cnt)
                cnt++;
            else break;
        }
        return cnt;
    }
}
