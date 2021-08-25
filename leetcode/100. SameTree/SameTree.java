class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        /*
            1. 노드가 둘다 null일 경우 -> 같으니까 true
            2. 노드가 둘중 하나만 null일 경우 -> false
            3. 노드의 값이 같은 경우 -> true
                3.1 recursion으로 왼쪽 오른쪽 노드 탐색 -> 둘중하나라도 false나오면 false반환
            4. 노드의 값이 다른 경우 -> false 
        */
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val == q.val) {
           return isSameTree(p.left, q.left) && isSameTree(p.right, q.right); 
        } else {
          return false;  
        }
    }
}