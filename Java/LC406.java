public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int[][] cnts = new int[people.length][1];
        for (int i = 0; i < people.length; i++) cnts[i][0] = people[i][1];
        for (int i = 0; i < people.length; i++) {
            int pos = -1;
            for (int j = i; j < people.length; j++) {
                if (people[j][1] == 0) {
                    if (pos < 0 || people[pos][0] > people[j][0]) {
                        pos = j;
                    }
                }
            }
            //System.out.println(i+" "+pos);
            swap(people, i, pos);
            swap(cnts, i, pos);
            for (int j = i + 1; j < people.length; j++) {
                if (people[j][0] <= people[i][0]) {
                    people[j][1]--;
                }
            }
        }
        for (int i = 0; i < people.length; i++) people[i][1] = cnts[i][0];
        return people;
    }
    private void swap(int[][] arr, int i, int j) {
        int[] tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}