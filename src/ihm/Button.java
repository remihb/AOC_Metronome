package ihm;

import command.Command;

public class Button implements IButton{

	private Command command;
	
	/**
	 * @param command
	 * set the associated command to the button
	 */
	public Button(Command command) {
		super();
		this.command = command;
	}

	/* (non-Javadoc)
	 * @see ihm.IButton#getCommand()
	 */
	@Override
	public Command getCommand() {
		return this.command;
	}

}
