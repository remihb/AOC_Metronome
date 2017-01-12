package engine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.Timer;

import command.Command;

/**
 * @author remihb
 *
 */
public class Engine extends Thread implements IEngine {

	private static final int MIN_TEMPO = 30;
	private static final int MAX_TEMPO = 300;
	private static final int MIN_MEASURE = 1;
	private static final int MAX_MEASURE = 7;

	private HashMap<String, Command> commands;
	private boolean active;
	private int tempo;
	private int measure;
	private int counter;

	/**
	 * initialize variables and command hashmap
	 */
	public Engine() {
		this.commands = new HashMap<String, Command>();
		this.active = false;
		this.counter = 0;
		this.tempo = 100;
		this.measure = 4;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see engine.IEngine#getMinTempo()
	 */
	@Override
	public int getMinTempo() {
		return MIN_TEMPO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see engine.IEngine#getMaxTempo()
	 */
	@Override
	public int getMaxTempo() {
		return MAX_TEMPO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see engine.IEngine#getMinMeasure()
	 */
	@Override
	public int getMinMeasure() {
		return MIN_MEASURE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see engine.IEngine#getMaxMeasure()
	 */
	@Override
	public int getMaxMeasure() {
		return MAX_MEASURE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see engine.IEngine#isActive()
	 */
	@Override
	public boolean isActive() {
		return active;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see engine.IEngine#setActive(boolean)
	 */
	@Override
	public void setActive(boolean active) {
		this.active = active;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see engine.IEngine#getTempo()
	 */
	@Override
	public int getTempo() {
		return tempo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see engine.IEngine#setTempo(int)
	 */
	@SuppressWarnings("static-access")
	@Override
	public void setTempo(int tempo) {
		this.tempo = (tempo >= this.MIN_TEMPO) ? (tempo <= this.MAX_TEMPO) ? tempo : this.MAX_TEMPO : this.MIN_TEMPO;
		this.commands.get("UpdateTempo").execute();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see engine.IEngine#getMeasure()
	 */
	@Override
	public int getMeasure() {
		return measure;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see engine.IEngine#setMeasure(int)
	 */
	@SuppressWarnings("static-access")
	@Override
	public void setMeasure(int measure) {
		this.measure = (measure >= this.MIN_MEASURE) ? (measure <= this.MAX_MEASURE) ? measure : this.MAX_MEASURE
				: this.MIN_MEASURE;
		this.commands.get("UpdateMeasure").execute();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see engine.IEngine#setCommands(java.lang.String, command.Command)
	 */
	@Override
	public void setCommands(String s, Command c) {
		this.commands.put(s, c);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		
		/**
		 * command execution during timer cycle
		 */
		ActionListener actListner = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {

				counter++;
				if (counter == 1) {
					commands.get("BeatMeasure").execute();
				} else {
					commands.get("BeatTempo").execute();
				}
				if (counter >= measure) {
					counter = 0;
				}
			}

		};

		/**
		 * timer cycle
		 */
		int currentTempo = this.tempo;
		int delay = Math.round(60000 / currentTempo);
		Timer timer = new Timer(delay, actListner);
		while (true) {
			if (this.active) {
				if (!timer.isRunning()) {
					this.counter = 0;
					timer.start();
				}
				if (currentTempo != this.tempo) {
					timer.stop();
					currentTempo = this.tempo;
					delay = Math.round(60000 / currentTempo);
					timer.setDelay(delay);
					this.counter = 0;
					timer.start();
				}
			} else {
				if (timer.isRunning()) {
					timer.stop();
				}
			}
		}
	}
}
