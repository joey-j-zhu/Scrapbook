package Codelet;
/*
    A class to handle the graphical grouping of codelets, primarily through stacking.   
        - The last item in the stack must have greater depth than the first item.
        - Joins, splits, and steps within the group keep it intact. Joining any part of the group outside immediately releases the stack.
        - Because of this, stacks are very very simple from the UI perspective: just select a start and an end codelet, nothing else needed.

    Stacked windows have more dependency among their display variables:
        - Moving the stack's upper left corner moves all subwindows in the main column accordingly
        - Moving the stack's lower right corner does the same width change for all windows and tabs
        - Moving the lower right corner of anything inside the stack pushes down y values accordingly for all subwindows below it.
        - Minimizing or un-minimizing a window in the stack changes y values for all subwindows beneath by its height accordingly.

    To create a stack:
        - Rescale all widths to match the first codelet.
        - For each following codelet:
            - Place under the last-stacked codelet.
            - If it's a base codelet, render as is.
            - If it's a (contiguous segment of) local codelet(s), tab the first codelet of the segment and place the tab under the last-stacked codelet.
                - Keep the local codelets in place..

    To release a stack:
        - Leave every subwindow in its respective place.
        - Delete tabs

    @ author Joey Zhu
*/ 

public class WindowStack {
    public WindowStack(CodeletGroup group) {
    }

    public void stack() {

    }
    
    public void unstack() {

    }
}
