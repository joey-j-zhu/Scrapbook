package Codelet;
/*
    Codelets are sections of code which link together to replicate the original code. Each Node,
    as well as having linked-list data, also point to Frames which describe their environment
    and scope in the program. Traversing the Nodes should be equivalent to performing a 
    DFS on the frames.

    Codelets also mediate between classes with GUI parameters and the actual GUI. 
    
    Semantics-wise, "Codelet" and "Node" are synonymous.

    @author Joey Zhu
 */
 public class Codelet {
   // Node navigation variables
   private int _startLine;
   private int _endLine;
   private Codelet _prevNode;
   private Codelet _nextNode;
   // Every Node points to a Frame, which contains everything needed to recreate a Python environment
   private Frame _frame;
   private int _depth;

   private Subwindow _subwindow;


   
   // Node creation/deletion is restricted to initializing, joining, and splitting. No explicit construction.
   // Avoid using this method outside class or inherited classes
   public Codelet(int start, int end, Codelet prev, Codelet next, Frame frame, int depth, Subwindow subwindow) {
      _startLine = start;
      _endLine = end;
      _prevNode = prev;
      _nextNode = next;
      _frame = frame;
      _depth = depth;
      _subwindow = subwindow;
   }

   // Getter methods
   public int getStartLine() { return _startLine; }
   public int getEndLine() { return _endLine; }
   public Codelet getPrevNode() { return _prevNode; }
   public Codelet getNextNode() { return _nextNode; }
   public Frame getFrame() { return _frame; }
   public int getDepth() { return _depth; }
   public Subwindow getSubwindow() {return _subwindow; }

   /* 
      Initialize a new system of Nodes based on this file. Create a new rootNode with "default"
      parameters, whose only child is the entire file's code.
   */
   public static Codelet initCodelet(Object file, int width, int height) {
      return new Codelet(0, 0, null, null, new Frame(), 0, Subwindow.initSubwindow(width, height));
   }

   /* 
      Split a new Node off this current Node and return it.
   */
   public Codelet split(int newEndLine) {
      boolean isValid = (newEndLine < _endLine && newEndLine >= _startLine);
      if (isValid) {
         Subwindow newSubwindow = _subwindow.splitSubwindow();
         Codelet newNode = new Codelet(newEndLine + 1, _endLine, this, _nextNode,  _frame, _depth, newSubwindow);
         _nextNode = newNode;
         return newNode;
      } else {
         // throw error: newEndLine out of range
         return null;
      }
   }

   /*
      Absorb all succeeding Nodes until reaching an endNode into a single Node. The endNode
      must be the same depth as this node so we can get successfully drop out frames.
   */
   public void join(Codelet endNode) {
      Codelet iterNode = this;
      while (iterNode != null) {
         if (iterNode == endNode) {
            if (iterNode._depth == _depth) {
               dropFrames(this, endNode);
               _endLine = endNode._endLine;
               _nextNode = endNode._nextNode;
            } else {
               // throw error: start and end Nodes' depths don't match
            }
            break;
         }
         iterNode = iterNode._nextNode;
      }
      if (iterNode == null) {
         // throw error: end Node wasn't found after the start Node
      }
   }

   /*
      Push the node one level deeper in scope. Cannot push any deeper
   */
   public void step() {
      boolean isValid =  (_depth - _prevNode._depth < 1);
      if  (isValid) {
         _frame = new Frame();
         _frame.setParentFrame(_prevNode._frame);
         _depth += 1;
      } else {
         // throw error: Node's scope cannot exceed one more than its predecessor
      }
   }

   // Drop all frames between startNode and endNode after joining a list of Nodes
   private void dropFrames(Codelet startNode, Codelet endNode) {
      Codelet iterNode = startNode;
      while (iterNode != endNode._nextNode) {
         iterNode._frame.drop();
         iterNode = iterNode._nextNode;
      }
   }
}