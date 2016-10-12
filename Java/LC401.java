public class Solution {
    public List<String> readBinaryWatch(int num) {
        int i;
        int[] led = new int[10];
        List<String> ans = new ArrayList<>();
        helper(led, ans, 0, 0, num > 10 ? 10 : num);
        return ans;
    }
    private void helper(int[] led, List<String> ans, int index,
        int one, int num) {
        if (one >= num) {
            int hour = 0, minute = 0;
            int i;
            for (i = 0; i < 4; i++) {
                hour += led[i] << (3 - i);
            }
            for (i = 0; i < 6; i++) {
                minute += led[4 + i] << (5 - i);
            }
            if (hour <= 11 && minute <= 59) {
                StringBuilder time = new StringBuilder();
                time.append(hour).append(":");
                if (minute < 10) time.append("0");
                time.append(minute);
                ans.add(time.toString());
            }
            return;
        }
        if (index >= led.length) return;
        helper(led, ans, index + 1, one, num);
        led[index] = 1;
        helper(led, ans, index + 1, one + 1, num);
        led[index] = 0;
    }
}