package mx.cinvestav.cs.computacion.movil.mow.client.forms;

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
public class ShowMessagesMenu 
    extends List 
    implements CommandListener {

    private final CommandListener commandListener;
    private Command selectButton;

    private Object[][] options = {
	{"New message", null},
	{"Inbox", null},
	{"Draft", null},
	{"Sent", null},
	{"Outbox", null},
	{"Options", null}
    };

    public ShowMessagesMenu(CommandListener cl) {
	super("Messages Over Wifi", Choice.EXCLUSIVE);

	this.commandListener = cl;

	// Load options
	for(int i=0; i<options.length; i++)
	    append((String)options[i][0], (Image)options[i][1]);

	addCommand(selectButton = new Command("Select", Command.SCREEN, 1));

	setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
	if(c == selectButton) {
	    switch(getSelectedIndex()) {
	    case 0:	// New Message
		EditMessage message = new EditMessage(this,this);
		MowClient.display.setCurrent(message);
		break;
	    case 1:	// Inbox
		// TODO: Go to inbox
		break;
	    case 2:	// Draft
		// TODO: Go to draft messages
		break;
	    case 3:	// Sent
		// TODO: Go to sent messages
		break;
	    case 4:	// Outbox
		// TODO: Go to outbox
		break;
	    case 5:	// Options
		ShowOptions options = new ShowOptions(this,this);
		MowClient.display.setCurrent(options);
		break;
	    }
	}
	    
	commandListener.commandAction(c, d);
    }
}
