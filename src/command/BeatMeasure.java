package command;

import controller.Controller;
import controller.IController;

/**
 * @author remihb
 * Command for light the ihm measure led according to the timer cycle of the engine
 */
public class BeatMeasure implements Command {

	private IController controller;

    /**
     * @param controller
     * link the command to the controller
     */
	public BeatMeasure(Controller controller) {
		this.controller = controller;
	}

	/* (non-Javadoc)
	 * @see command.Command#execute()
	 */
	@Override
	public void execute() {
		controller.beatMeasure();
	}
}
