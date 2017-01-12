package ihm;

import command.Command;

/**
 * @author remihb
 * Button interface for linking the view's buttons and the performed methods in the ihm
 */
public interface IButton {

	/**
	 * @return 
	 * call the associated command to execute it on button use
	 */
	Command getCommand();

}
