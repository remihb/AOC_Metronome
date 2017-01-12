package command;

import controller.Controller;
import controller.IController;

/**
 * @author remihb
 * Command that start the engine and allow it to launch the timer
 */
public class Stop implements Command {

    private IController controller ;

    /**
     * @param controller
     * link the command to the controller
     */
    public Stop(Controller controller){
        this.controller = controller;
    }

    /* (non-Javadoc)
     * @see command.Command#execute()
     */
    @Override
    public void execute() {
        controller.stop();
    }
}
