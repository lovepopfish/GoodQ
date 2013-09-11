import java.util.*;
public class StringMatch {
    // 预处理初始化
    SuffixTreeNode root;
    
    public boolean search(String s){
        if (s.length()==0) return true;
        SuffixTreeNode cur = root;
        for(int i=0;i<s.length();i++){
            cur = cur.getChild(s.charAt(i));
            if (cur==null) return false;
        }
        return true;
    }
    
    public class SuffixTreeNode{
        LinkedList<SuffixTreeNode> children;
        char c;
        
        public SuffixTreeNode(){
            children = new LinkedList<SuffixTreeNode>();
        }
        
        public SuffixTreeNode(char c){
            this();
            this.c = c;
        }
        
        public SuffixTreeNode getChild(char c){
            for(SuffixTreeNode child : children){
                if (child.c == c){
                    return child;
                }
            }
            return null;
        }
        
        public void addWord(String s){
            if (s.length()==0) return;
            SuffixTreeNode cur = getChild(s.charAt(0));
            if (cur==null){
                cur = new SuffixTreeNode(s.charAt(0));
                children.add(cur);
            }
            cur.addWord(s.substring(1));
        }
    }
    
    public void initWithString(String str) {
        root = new SuffixTreeNode();
        for(int i=0;i<str.length();i++){
            root.addWord(str.substring(i));
        }
    }
    
    // 如果query是str的字串,返回true,否则返回false
    public boolean existSubString(String query) {
        return search(query);
    }
}