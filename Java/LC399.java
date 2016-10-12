public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, String> link = new HashMap<>();
        Map<String, Double> multiplier = new HashMap<>();
        double[] ans = new double[queries.length];
        
        // build graph for union find
        for (int i = 0; i < equations.length; i++) {
            String A = equations[i][0], B = equations[i][1];
            double kVal = values[i];
            if (!link.containsKey(B)) {
                link.put(B, B);
                multiplier.put(B, 1.0);
                //System.out.println(B);
            }
            if (kVal == 0) {
                setLink(A, link, "0", 1, multiplier);
            } else {
                setLink(A, link, B, kVal, multiplier);
            }
        }
        
        // check the queries
        for (int i = 0; i < queries.length; i++) {
            String A = queries[i][0], B = queries[i][1];
            //if (B != 0) {
            if (!"0".equals(find(B, link, multiplier))) {
                String C = find(A, link, multiplier);
                String D = find(B, link, multiplier);
                if (C != null && C.equals(D)) {
                    ans[i] = multiplier.get(A) / multiplier.get(B);
                } else {
                    ans[i] = -1;
                }
            } else {
                ans[i] = -1;
            }
        }
        return ans;
    }
    
    private void setLink(String A, Map<String, String> link, String B, double num,
        Map<String, Double> multiplier) {
        if (link.containsKey(A)) {
            String C = link.get(A);
            if (!C.equals("0") && !C.equals(A)) {
                setLink(C, link, B, num / multiplier.get(A), multiplier);
            }
        }
        link.put(A, B);
        multiplier.put(A, num);
    }
    
    private String find(String A, Map<String, String> link, Map<String, Double> multiplier) {
        if (A == null) return null;
        if (A.equals("0")) return "0";
        String B = link.get(A);
        if (B == null || A.equals(B)) return B;
        String C = find(B, link, multiplier);
        //System.out.println(A + " " + B + " " + C);
        link.put(A, C);
        multiplier.put(A, multiplier.get(A) * multiplier.get(B));
        return C;
    }
}