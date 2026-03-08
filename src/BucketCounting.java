public class BucketCounting {
    //H-Index
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] countingArray = new int[n+1];

        for (int citation: citations) {
            if (citation>=n)
                countingArray[n]++;
            else
                countingArray[citation]++;
        }

        int numOfPapers=0;
        for (int h = n; h>=0; h--) {
            numOfPapers+=countingArray[h];
            if (numOfPapers>=h)
                return h;
        }
        return 0;
    }
}
