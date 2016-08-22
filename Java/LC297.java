/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializeHelper(root).toString();
    }

    public StringBuilder serializeHelper(TreeNode root) {
        if (root != null) {
            StringBuilder parent = new StringBuilder(((Integer) root.val).toString());
            //System.out.println(parent.toString());
            StringBuilder left = serializeHelper(root.left);
            StringBuilder right = serializeHelper(root.right);
            return parent.append("$").append(left).append(right);
        } else {
            return new StringBuilder("#$");
        }
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> s = new LinkedList<>();
        s.addAll(Arrays.asList(data.split("\\$")));
        return deserializeHelper(s);
    }
    
    public TreeNode deserializeHelper(LinkedList<String> s) {
        String tmp = s.remove();
        //System.out.println(tmp);
        if (!tmp.equals("#")) {
            TreeNode root = new TreeNode(Integer.parseInt(tmp));
            root.left = deserializeHelper(s);
            root.right = deserializeHelper(s);
            return root;
        }
        return null;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));