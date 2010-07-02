package mx.cinvestav.cs.computacion.movil.mow.client.forms;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;

/**
 * @author Israel Buitron
 */
public class ShowOptions 
    extends Form 
    implements CommandListener {

    private final CommandListener commandListener;
    private final Displayable previousScreen;
    private Command backButton;
    private Command saveButton;
    private Command restoreButton;

    private TextField nickname;

    public ShowOptions(CommandListener cl, Displayable ps) {
	super("MOW Options");

	this.commandListener = cl;
	this.previousScreen = ps;

	append(nickname = new TextField("Nickname", "", 16, TextField.ANY));

	addCommand(backButton = new Command("Back", Command.BACK, 1));
	addCommand(saveButton = new Command("Save Options", Command.SCREEN, 1));
	addCommand(restoreButton = new Command("Restore Options", Command.SCREEN, 5));

	setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
	if(c == backButton)
	    MowClient.display.setCurrent(previousScreen);
	else if(c == saveButton) {
	    // TODO: Save options
	} else if(c == restoreButton) {
	    // TODO: Restore options
	}
	    
	commandListener.commandAction(c, d);
    }
}
