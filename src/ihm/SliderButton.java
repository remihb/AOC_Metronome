package ihm;

import command.Command;

/**
 * @author remihb
 * Button for changing the engine tempo value
 */
public class SliderButton extends Button{

	public SliderButton(Command command) {
		super(command);
	}

	private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
