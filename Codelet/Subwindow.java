package Codelet;
/* 
    The Subwindow describes how a Node should be displayed. Its implementation
    should mirror that of the Node's. Subwindows should not use any internal data
    structures, which should only be contained in Node and Frame. 
    
    In the UI scheme, Subwindow is just base-level variables to be accessed in higher
    levels to be used for animation and rendering.

    @ author Joey Zhu
*/

public class Subwindow {
    // When displaying a minimized subwindow, this replaces the subwindow's height
    public static int tabHeight;

    // Self-explanatory
    private int _displayX;
    private int _displayY;
    private int _displayHeight;
    private int _displayWidth;
    private int _scrollX;
    private int _scrollY;
    private boolean _isMinimized;
    private DisplayTab _tab;

    public Subwindow(int x, int y, int width, int height, int scrollX, int scrollY) {
        _displayX = x;
        _displayY = y;
        _displayHeight = height;
        _displayWidth = width;
        _scrollX = scrollX;
        _scrollY = scrollY;
        _isMinimized = false;
        _tab = null;
    }

    // Getters
    public int x() { return _displayX; }
    public int y() { return _displayY; }
    public int height() { return _displayHeight; }
    public int width() { return _displayWidth; }
    public int scrollX() { return _scrollX; }
    public int scrollY() { return _scrollY; }
    public boolean isMinimized() {return _isMinimized; }
    public DisplayTab getTab() {return _tab; }

    // Setters
    public void move(int newX, int newY) {
        _displayX = newX;
        _displayY = newY;
    }
    public void resize(int newHeight, int newWidth) {
        _displayWidth = newWidth;
        _displayHeight = newHeight;
    }
    public void setScrollX(int newScrollX) { _scrollX = newScrollX; }
    public void setScrollY(int newScrollY) { _scrollY = newScrollY; }
    public void minimizeWindow() { _isMinimized = true; }
    public void expandWindow() { _isMinimized = false; }
    public boolean hasTab() { return (_tab == null); }
    public void setTab(DisplayTab tab) { _tab = tab; }
    public void removeTab() { _tab = null; }

    /*
        Create a new singular Subwindow to fill the current screen
    */
    public static Subwindow initSubwindow(int width, int height) {
        return new Subwindow(0, 0, width, height, 0, 0);
    }

    /*
        Break this subwindow in half, heightwise, and return the new subwindow
    */
    public Subwindow splitSubwindow() {
        int newWidth = _displayWidth;
        int newHeight = _displayHeight / 2;
        int newX = _displayX;
        int newY = _displayY + newHeight;
        int newScrollX = _scrollX;
        int newScrollY = 0;
        
        _displayHeight = newHeight;
        return new Subwindow(newX, newY, newWidth, newHeight, newScrollX, newScrollY);
    }

    // When joining, all subwindows become absorbed into the first one.
    // No method is needed here
}
