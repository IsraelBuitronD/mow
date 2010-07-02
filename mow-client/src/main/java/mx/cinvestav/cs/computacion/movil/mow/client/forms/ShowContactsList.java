package mx.cinvestav.cs.computacion.movil.mow.client.forms;

import mx.cinvestav.cs.computacion.movil.mow.client.vo.Contact;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.List;

/**
 * @author Israel Buitron
 */
public class ShowContactsList 
    extends List 
    implements CommandListener {

    private Command backButton;
    private Command sendButton;
    private final CommandListener commandListener;
    private final Displayable previousScreen;

    private Contact[] contacts = {};

    public ShowContactsList(CommandListener cl, Displayable ps) {
	this(cl,ps,new Contact[] {});
    }

    public ShowContactsList(CommandListener cl, Displayable ps, Contact[] c) {
	super("Send to", Choice.EXCLUSIVE);

	this.commandListener = cl;
	this.previousScreen = ps;
	this.contacts = c;

	addCommand(backButton = new Command("Back", Command.BACK, 1));
	addCommand(sendButton = new Command("Send", Command.SCREEN, 1));

	setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
	if(c == backButton)
	    MowClient.display.setCurrent(previousScreen);
	else if(c == sendButton) {
	    int selected = getSelectedIndex();
	    if(selected<0) {
		Alert alert = new Alert ("Contact List","You must select a contact in order to send a message.", null, AlertType.WARNING);
		alert.setTimeout(Alert.FOREVER);
		MowClient.display.setCurrent(alert, this);
	    } else {
		Contact contact = contacts[selected];
		// TODO: Send message
	    }
	}
	    
	commandListener.commandAction(c, d);
    }
}
