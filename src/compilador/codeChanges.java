package compilador;

import java.awt.Color;


public class codeChanges implements Runnable{
    GICompiler main;
    public codeChanges(GICompiler main) {
        this.main = main;
    }
    
    public void run () {
        while (true) {            
            //main.unPaintNoFunctions();
            main.paintFunctions(main.getFunctionsToColor(), Color.blue);
            main.paintFunctions(main.getRegs(), Color.GREEN);
        }
    }
    
}
