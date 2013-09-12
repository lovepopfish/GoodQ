import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


public class printTree {
    public class TreeNode{
        int id;
        String name;
        int parentId;
        public TreeNode(int id, String name, int parentId){
            this.id = id;
            this.name = name;
            this.parentId = parentId;
        }
    }
    
    public TreeNode[] createTree(){
        TreeNode[] tree = new TreeNode[7];
        tree[0] = new TreeNode(1,"NodeA",0);
        tree[1] = new TreeNode(2,"NodeB",1);
        tree[2] = new TreeNode(3,"NodeC",1);
        tree[3] = new TreeNode(4,"NodeD",1);
        tree[4] = new TreeNode(5,"NodeE",2);
        tree[5] = new TreeNode(6,"NodeF",0);
        tree[6] = new TreeNode(7,"NodeG",6);
        return tree;
    }
    
    public void print(TreeNode[] tree){
        HashMap<Integer,LinkedList<Integer>> map = new HashMap<Integer,LinkedList<Integer>>();
        HashMap<Integer,String> getName = new HashMap<Integer,String>();
        ArrayList<Integer> root = new ArrayList<Integer>();
        for(TreeNode node : tree){
            getName.put(node.id,node.name);
            if (node.parentId==0) {
                root.add(node.id);
            }
            if (!map.containsKey(node.parentId)){
                LinkedList<Integer> list = new LinkedList<Integer>();
                list.add(node.id);
                map.put(node.parentId, list);
            } else {
                LinkedList<Integer> list = map.get(node.parentId);
                list.add(node.id);
            }
        }
        for(Integer i : root){
            dfs(map,getName,i,0);
        }
    }
    
    public void dfs(HashMap<Integer,LinkedList<Integer>> map, HashMap<Integer,String> getName, int id, int level){
        int space = level;
        while(space>0){
            System.out.print("-");
            space--;
        }
        System.out.println(getName.get(id));
        LinkedList<Integer> list = map.get(id);
        if (list==null) return;
        for (Integer i:list){
            dfs(map,getName,i,level+1);
        }
    }
    
    public static void main(String[] args){
        printTree p = new printTree();
        TreeNode[] tree = p.createTree();
        p.print(tree);
    }
}
