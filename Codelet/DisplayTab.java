package Codelet;
/*
    A DisplayTab is basically a minimized alias to a subwindow, displayed just like one.
    DisplayTab always points to a parent Subwindow, which does not need to know about the DisplayTab.
*/
public class DisplayTab extends Subwindow {
    private Subwindow _parentWindow;

    // Constraining subwindow creation to joining, 
    public DisplayTab(int x, int y, int width, Subwindow parent) {
        super(x, y, width, 0, 0, 0);
        _parentWindow = parent;
    }

    // Getters
    public Subwindow getParent() { return _parentWindow; }

    // Setters
}