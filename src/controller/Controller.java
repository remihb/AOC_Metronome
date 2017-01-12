package controller;

import command.BeatMeasure;
import command.BeatTempo;
import command.UpdateMeasure;
import command.UpdateTempo;
import engine.Engine;
import engine.IEngine;
import ihm.Ihm;

/**
 * @author remihb
 * 
 */
public class Controller implements IController {

	private Engine engine;
	private Ihm ihm;

	/**
	 * @param ihm
	 * initialize engine and engine's commands to call
	 */
	public Controller(Ihm ihm) {
		this.engine = new Engine();
		this.ihm = ihm;
		this.engine.start();

		this.engine.setCommands("BeatTempo", new BeatTempo(this));
		this.engine.setCommands("BeatMeasure", new BeatMeasure(this));
		this.engine.setCommands("UpdateTempo", new UpdateTempo(this));
		this.engine.setCommands("UpdateMeasure", new UpdateMeasure(this));
	}

	/**
	 * @param ihm
	 */
	public void setIhm(Ihm ihm) {
		this.ihm = ihm;
	}

	/**
	 * @return engine
	 */
	public IEngine getEngine() {
		return engine;
	}

	/* (non-Javadoc)
	 * @see controller.IController#beatTempo()
	 */
	@Override
	public void beatTempo() {
		this.ihm.beatTempo();
	}

	/* (non-Javadoc)
	 * @see controller.IController#beatMeasure()
	 */
	@Override
	public void beatMeasure() {
		this.ihm.beatMeasure();
	}

	/* (non-Javadoc)
	 * @see controller.IController#updateTempo()
	 */
	@Override
	public void updateTempo() {
		if (this.ihm.getTempoLabel() != null) {
			this.ihm.getTempoLabel().setText(Integer.toString(this.engine.getTempo()));
		}
	}
	
	/* (non-Javadoc)
	 * @see controller.IController#updateMeasure()
	 */
	@Override
	public void updateMeasure() {
		if (this.ihm.getMeasureLabel() != null) {
			this.ihm.getMeasureLabel().setText(Integer.toString(this.engine.getMeasure()));
		}
	}
	/* (non-Javadoc)
	 * @see controller.IController#start()
	 */
	@Override
	public void start() {
		this.engine.setActive(true);
	}

	/* (non-Javadoc)
	 * @see controller.IController#stop()
	 */
	@Override
	public void stop() {
		this.engine.setActive(false);
	}

	/* (non-Javadoc)
	 * @see controller.IController#updateCursor()
	 */
	@Override
	public void updateCursor() {
		this.engine.setTempo((int) this.ihm.getCursor().getPosition());
	}

	/* (non-Javadoc)
	 * @see controller.IController#incMeasure()
	 */
	@Override
	public void incMeasure() {
		this.engine.setMeasure(this.engine.getMeasure() + 1);
	}

	/* (non-Javadoc)
	 * @see controller.IController#decMeasure()
	 */
	@Override
	public void decMeasure() {
		this.engine.setMeasure(this.engine.getMeasure() - 1);
	}
}
