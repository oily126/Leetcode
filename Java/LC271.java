public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        int[] nums = new int[strs.size()];
        StringBuilder sb = new StringBuilder();
        sb.append(strs.size());
        for (int i = 0; i < strs.size(); i++) {
            sb.append(",").append(strs.get(i).length());
        }
        sb.append(",");
        for (String s : strs) sb.append(s);
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        //System.out.println(s);
        String[] parts = s.split(",", 2);
        int n = Integer.parseInt(parts[0]);
        int[] nums = new int[n];
        String[] numStrs = parts[1].split(",", n + 1);
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(numStrs[i]);
        }
        
        List<String> ans = new ArrayList<>(n);
        int start = 0;
        for (int i = 0; i < n; i++) {
            ans.add(numStrs[n].substring(start, start + nums[i]));
            start += nums[i];
        }
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));