package command;

import controller.Controller;
import controller.IController;

/**
 * @author remihb
 * Command for decrement the measure counter of the engine
 */
public class DecMeasure implements Command {
    
	private IController controller ;

    /**
     * @param controller
     * link the command to the controller
     */
   public DecMeasure(Controller controller){
        this.controller = controller;
    }

    /* (non-Javadoc)
     * @see command.Command#execute()
     */
    @Override
    public void execute() {
        controller.decMeasure();
    }
}
