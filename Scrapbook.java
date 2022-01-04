import java.util.Collection;

import Codelet.Codelet;
import Codelet.CodeletGroup;
/*
    The driver class for GUI features. The current implementation is only a view of the original code, which is to
    be edited in a separate window. Implementation should allow such that in the future, typing/editing can be done
    directly on the GUI. 
    
    --- Core Operations ---
        - <+>: zoom in
        - <->: zoom out
        - <T>: split the codelet where the cursor is.
        - <J>: join the selected codelets.
        - <S>: Step in the selected codelets as far as possible.
        - <G>: Group the selected codelets.

        - Undo/Redo support


    --- Codelet window resizing ---
        - Clicking and dragging fullwindow scrollbars change fullwindow x and y scrolls.
        - Clicking on a codelet selects it.
        - Shift-click or right-click while there is a selected codelet selects a second codelet.

        - Clicking & dragging near upper left corner of main selection changes x and y values.
        - Clicking and dragging scrollbars change x and y scrolls.
        - Clicking and dragging lower right corner of main selection changes width and height.

        - GUI only updates when mouse is released. Dynamically, draw a bounding box corresponding with the changing subwindow.
        
    
    --- Code-Codelet Interface ---
        - Hovering over a feature in the original code highlights a corresponding codelet in the Scrapbook.
        - Double-clicking on a codelet in the Scrapbook automatically navigates to the corresponding line in the original code.


    --- Restrictions ---
        - This class should never directly access Subwindow, WindowStack, or DisplayTab. It should only access them through Codelets!

    @author Joey Zhu
*/
public class Scrapbook {
    private Codelet _root;
    private Collection<CodeletGroup> _groups;
    private Codelet _mainSelection;
    private Codelet _secondSelection;

    // Global display variables
    private int scrollX;
    private int scrollY;
    private float zoom;



    public Scrapbook() {

    }

    public void render() {
        // TODO: display all on-screen codelet backgrounds.
        //TODO: display all on-screen codelets. Only need the root, we can DFS through.
    }

    public void update() {
        // TODO: register mouse input
        // TODO: 
    }



    public void setRoot(Codelet root) { _root = root; }

    public void addGroup(CodeletGroup group) { _groups.add(group); }

    public void removeGroup(CodeletGroup group) { _groups.remove(group); }


    // Selection methods
    // Clear all selections and mark the given Codelet as the selected ones
    public void selectCodelet(Codelet codelet) {
        _mainSelection = codelet;
        _secondSelection = null;
    }

    // Add this codelet as the second selection. If it precedes the main selection, swap
    public void secondSelectCodelet(Codelet codelet) {
        //TODO: Implement
    }

     // Clear all selections
    public void deselect() {
        _mainSelection = null;
        _secondSelection = null;
    }

    public void performSplit(int newEndLine) {
        _mainSelection.split(newEndLine);
    }

    public void performJoin() {
        _mainSelection.join(_secondSelection);
    }

    public void performStep() {
        _mainSelection.step();
    }

    public void performGroup() {
        CodeletGroup group = new CodeletGroup(_mainSelection, _secondSelection);
    }

    // 
}
