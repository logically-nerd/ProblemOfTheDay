//Duplicate subtree in Binary Tree
// https://practice.geeksforgeeks.org/problems/duplicate-subtree-in-binary-tree/1
//12-10-2023

//curtsey-comment
//will understand and redo it once more
class Solution {
     private Map<String, Integer> mp = new HashMap<>();

    String func(Node root) {
        if (root == null) return "";

        String l = func(root.left);
        String r = func(root.right);

        String s = Integer.toString(root.data) + l + r;

        mp.put(s, mp.getOrDefault(s, 0) + 1);
        return s;
    }

    int dupSub(Node root) {
        func(root);
        int cnt = 0;
        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            if (entry.getKey().length() >= 2 && entry.getValue() > 1) {
                cnt = 1;
                break;
            }
        }
        return cnt;
    }
}