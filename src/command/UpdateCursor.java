package command;

import controller.Controller;

/**
 * @author remihb
 * Command for update the engine tempo value according to the tempo slider changes in the ihm
 */
public class UpdateCursor implements Command {

    private Controller controller;

    /**
     * @param controller
     * link the command to the controller
     */
    public UpdateCursor(Controller controller){
        this.controller = controller;
    }

    /* (non-Javadoc)
     * @see command.Command#execute()
     */
    @Override
    public void execute() {
        controller.updateCursor();
    }
}
