package Codelet;
import java.util.List;
import java.util.ArrayList;

/* 
    A class to handle database-like Codelet queries
    @author Joey Zhu
*/
public class CodeletQuery {
    public static Codelet root;
    public Codelet getRoot() { return root; }
    public void setRoot(Codelet newRoot) { root = newRoot; }

    /*
        Return the entire list of Nodes 
    */
    public List<Codelet> getAll() {
        List<Codelet> nodes = new ArrayList<Codelet>();
        Codelet iterNode = root;
        while (iterNode != null) {
            nodes.add(iterNode);
            iterNode = iterNode.getNextNode();
        }
        return nodes;
    }

    /*
        Return all children of the given codelet, in other words all succeeding
        codelets with greater depth until another codelet of same depth is reached.
    */
    public static List<Codelet> getChildren(Codelet codelet) {
        List<Codelet> children = new ArrayList<Codelet>();
        Codelet iter = codelet.getNextNode();
        while (iter != null && iter.getDepth() > codelet.getDepth()) {
            children.add(iter);
            iter = iter.getNextNode();
        }
        return children;
    }
}
