package Codelet;
import java.util.Collection;
/*
    Currently a placeholder for debugging GUI features.
    @ author Joey Zhu
*/
public class Frame {
    private Frame _parentFrame;
    private Collection<Frame> _childFrames;

    public Frame() {}

    // Doubly link this Frame with a parent frame
    public void setParentFrame(Frame parent) {
        _parentFrame = parent;
        _parentFrame._childFrames.add(this);
    }

    // Formally delete this frame and remove from parent collections
    public void drop() {
        _parentFrame._childFrames.remove(this);
    }
}
