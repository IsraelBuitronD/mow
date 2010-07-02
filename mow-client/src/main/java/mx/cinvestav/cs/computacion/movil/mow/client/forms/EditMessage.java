package mx.cinvestav.cs.computacion.movil.mow.client.forms;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.TextField;

/**
 * @author Israel Buitron
 */
public class EditMessage 
    extends TextBox 
    implements CommandListener {

    public static final int MAX_LENGTH_MSG = 140;

    private Command backButton;
    private Command sendToButton;
    private final CommandListener commandListener;
    private final Displayable previousScreen;

    public EditMessage(CommandListener cl, Displayable ps) {
	super("Edit Message", "", MAX_LENGTH_MSG, TextField.ANY);

	this.commandListener = cl;
	this.previousScreen = ps;

	addCommand(backButton = new Command("Back", Command.BACK, 1));
	addCommand(sendToButton = new Command("Send To", Command.SCREEN, 1));

	setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
	if(c == backButton) {
	    MowClient.display.setCurrent(previousScreen);
	} else if(c == sendToButton) {
	    // TODO: Load contact list to show
	    ShowContactsList screen = new ShowContactsList(this,this);
	    MowClient.display.setCurrent(screen);
	}
	
	commandListener.commandAction(c, d);
    }
}
