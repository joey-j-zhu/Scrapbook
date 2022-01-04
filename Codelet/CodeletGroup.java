package Codelet;
/*
    A class to handle the structural features of Codelets, particularly for
    grouping them for display purposes. 



    @ Joey Zhu
*/

public class CodeletGroup {
    // A codelet group is identified by its start and end codelets
    Codelet _startCodelet;
    Codelet _endCodelet;
    // Also associated with 
    WindowStack _stack;

    public CodeletGroup(Codelet startCodelet, Codelet endCodelet) {
        boolean isValid = (startCodelet.getDepth() == endCodelet.getDepth());
        Codelet iter = startCodelet;
        if (isValid) {
            while (iter != null) {
                iter = iter.getNextNode();
            }
            if (iter == null) {
                // throw error: end codelet was not found after start codelet
            }
            _startCodelet = startCodelet;
            _endCodelet = endCodelet;
        } else {
            // throw error: start and end codelets must be of the same depth
        }
    }

    public Codelet start() { return _startCodelet; }
    public Codelet end() { return _endCodelet; }

}
