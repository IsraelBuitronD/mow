package mx.cinvestav.cs.computacion.movil.mow.client.forms;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

/**
 * @author Israel Buitron
 */
public class MowClient 
    extends MIDlet 
    implements CommandListener {

    public static Display display;
    private static Displayable initialScreen;
    private Command exit;

    public MowClient() {
	display = Display.getDisplay(this);
    }

    public void commandAction(Command c, Displayable d) {
	if(c == exit)
	    try {
		destroyApp(true);
	    } catch(MIDletStateChangeException e) {
		e.printStackTrace();
	    }
    }
    
    protected void destroyApp(boolean b) 
	throws MIDletStateChangeException {
	notifyDestroyed();
    }
    
    protected void pauseApp() {}
    
    protected void startApp() 
	throws MIDletStateChangeException {
	initialScreen = new ShowMessagesMenu(this);
	exit = new Command("Exit", Command.EXIT, 1);
	initialScreen.addCommand(exit);
	display.setCurrent(initialScreen);
    }

}
