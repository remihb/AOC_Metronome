package command;

import controller.Controller;

/**
 * @author remihb
 * Command for update the ihm tempo label according to the tempo value of the engine
 */
public class UpdateMeasure implements Command {
    
	private Controller controller;

    /**
     * @param controller
     * link the command to the controller
     */
    public UpdateMeasure(Controller controller) {
        this.controller = controller;
    }

    /* (non-Javadoc)
     * @see command.Command#execute()
     */
    @Override
    public void execute(){
        controller.updateMeasure();
    }
}
