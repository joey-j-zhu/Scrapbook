import Codelet.*;
/*
    A majority of testing this project will be done in beta tests. Any unit tests we write
    can be easily tested by just using the GUI after we debug everything. Or maybe it's just me being lazy. Fingers crossed

    @author Joey Zhu
*/

public class Test {
    static final int WIDTH = 960;
    static final int HEIGHT = 540;

    public static void main(String[] args) {
        if (args[0].equals("test")) {
            Scrapbook window = new Scrapbook();
            Codelet base = Codelet.initCodelet(args[1], WIDTH, HEIGHT);
        }
    }
}
