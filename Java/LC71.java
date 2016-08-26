public class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        List<String> s = new ArrayList<>();
        int i;
        for (i = 0; i < dirs.length; i++) {
            if (dirs[i].equals("..")) {
                if (s.size() > 0) s.remove(s.size() - 1);
            } else if (dirs[i].equals(".") || dirs[i].equals("")) {
                // remain current directory
            } else {
                s.add(dirs[i]);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (i = 0; i < s.size(); i++) {
            ans.append("/").append(s.get(i));
        }
        if (ans.length() == 0) ans.append("/");
        return ans.toString();
    }
}