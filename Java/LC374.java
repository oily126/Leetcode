/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1, r = n, mid, result;
        while (l < r) {
            mid = (r - l) / 2 + l;
            result = guess(mid);
            if (result == 0) return mid;
            else if (result == 1) l = mid + 1;
            else if (result == -1) r = mid - 1;
        }
        return l;
    }
}