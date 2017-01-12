package command;

import controller.Controller;
import controller.IController;

/**
 * @author remihb
 * Command for increment the measure counter of the engine
 */
public class IncMeasure implements Command {

    private IController controller ;

    /**
     * @param controller
     * link the command to the controller
     */
    public IncMeasure(Controller controller){
        this.controller = controller;
    }

    /* (non-Javadoc)
     * @see command.Command#execute()
     */
    @Override
    public void execute() {
        controller.incMeasure();
    }
}
