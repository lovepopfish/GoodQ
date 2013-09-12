import java.util.Stack;
public class TreeTraversalGoOver{
    private TreeNode root;
    private class TreeNode{
        int val;
        TreeNode left,right;
        public TreeNode(int v){
            this.val = v;
        }
    }
    
    public void insert(int v){
        root = insert(root,v);
    }
    private TreeNode insert(TreeNode n, int v){
        if (n==null) return new TreeNode(v);
        if (v < n.val) n.left = insert(n.left,v);
        else if (v > n.val) n.right = insert(n.right,v);
        else n.val = v;
        return n;
    }
    
    public void inorder(){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode n = root;
        while (!stack.isEmpty() || n!=null){
            if (n!=null){
                stack.push(n);
                n = n.left;
            } else {
                n = stack.pop();
                System.out.println(n.val);
                n = n.right;
            }
        }
    }
    
    public void preorder(){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode n = root;
        while(!stack.isEmpty()||n!=null){
            if (n!=null){
                System.out.println(n.val);
                if (n.right!=null) stack.push(n.right);
                n = n.left;
            } else {
                n = stack.pop();
            }
        }
    }
    
    public void postorder(){
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.peek();
            if (prev==null||cur==prev.left||cur==prev.right){
                if (cur.left!=null){
                    stack.push(cur.left);
                }
                else if (cur.right!=null){
                    stack.push(cur.right);
                }
            } else if (prev == cur.left){
                if (cur.right!=null){
                    stack.push(cur.right);
                }
            } else{
                System.out.println(cur.val);
                stack.pop();
            }
            prev = cur;
        }
    }
    
    public void createBST(int[] arr){
        root = createBST(arr,0,arr.length-1);
    }
    private TreeNode createBST(int[] arr, int left, int right){
        if(left > right) return null;
        int mid = (left + right)/2;
        TreeNode n = new TreeNode(arr[mid]);
        n.left = createBST(arr,left,mid-1);
        n.right = createBST(arr,mid+1,right);
        return n;
    }
    
    public static void main(String[] args){
        TreeTraversalGoOver tree = new TreeTraversalGoOver();
        int[] arr = new int[9];
        for(int i=0;i<9;i++){
            arr[i] = i+1;
        }
        tree.createBST(arr);
        tree.inorder();
        System.out.println("--------------------");
        tree.preorder();
        System.out.println("--------------------");
        tree.postorder();
    }
}