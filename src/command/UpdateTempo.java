package command;

import controller.Controller;

/**
 * @author remihb
 * Command for update the ihm measure label according to the measure value of the engine
 */
public class UpdateTempo implements Command {
    
	private Controller controller;

    /**
     * @param controller
     * link the command to the controller
     */
    public UpdateTempo(Controller controller) {
        this.controller = controller;
    }

    /* (non-Javadoc)
     * @see command.Command#execute()
     */
    @Override
    public void execute(){
        controller.updateTempo();
    }
}
