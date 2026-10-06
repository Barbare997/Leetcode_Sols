import java.lang.reflect.Array;

public class BitManipulationSolutions {
    //Hamming Distance
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while (xor != 0) {
            count += xor & 1;
            xor >>= 1;
        }
        return count;
    }

    //Add Binary
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length()-1;
        int j = b.length()-1;

        while (i>=0 || j>=0 || carry >0) {
            int sum = carry;
            if (i>=0) sum += a.charAt(i--) - '0';
            if (j>=0) sum+= b.charAt(j--) - '0';

            sb.append(sum%2);
            carry=sum/2;

        }
        return sb.reverse().toString();

    }

    //Add Binary another solution (directly placing characters in a fixed size string)
    public String addBinary1(String a, String b) {
        int carry = 0;
        int i = a.length()-1, j = b.length()-1, k = Math.max(i , j) + 2;

        char  [] s = new char [k];

        int p = k-1;

        while (i>=0 || j>=0 || carry >0) {
            int sum = carry;
            if (i>=0) sum += a.charAt(i--) - '0';
            if (j>=0) sum+= b.charAt(j--) - '0';

            s[p--] = (char) ((sum%2) + '0');
            carry=sum/2;

        }
        return new String(s, p+1, k-p-1);

    }

    //Reverse bits
    public int reverseBits(int n) {
        StringBuilder builder = (new StringBuilder(String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0')).reverse());
        return Integer.parseInt(builder.toString(), 2);
    }

//    n <<= 1;   // left shift
//    n >>= 1;   // signed right shift
//    n >>>= 1;  // unsigned right shift

    public int reverseBits1(int n) {
        int ans = 0;
        for (int i=0; i<32; i++) {
            ans = (ans<<1) | (n&1);
            n >>>= 1;
        }

        return ans;
    }

    //Number of 1 Bits
    public int hammingWeight(int n) {
        int result = 0;
        while (n!=0) {
            result+=n%2;
            n/=2;
        }
        return result;
    }

    //Single Number
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int n: nums)
            result^=n;
        return result;
    }
}
