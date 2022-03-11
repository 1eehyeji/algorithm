package leetCode;

// Reverse Bits
public class Solution190 {

    public int reverseBits(int n) {
        int answer = 0;
        
        for (int i = 0; i < 32; ++i) {
            answer = answer << 1;
            
            if ((n & 1) > 0) {
                answer = answer | 1;
            }
            
            n = n >> 1;
        }
        
        return answer;
    }
}
