package ihm;

import static java.lang.Thread.sleep;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import main.App;
import command.DecMeasure;
import command.IncMeasure;
import command.Start;
import command.Stop;
import command.UpdateCursor;
import controller.Controller;

/**
 * @author remihb
 * Ihm containing fxml linked resources
 */
public class Ihm implements Initializable {

	private final String tempoSound = "tempo.mp3";
	private final String measureSound = "measure.mp3";

	private Controller controller;

	private StartButton start;
	private StopButton stop;
	private IncMeasureButton incMeasure;
	private DecMeasureButton decMeasure;
	private SliderButton cursor;

	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;
	@FXML
	private Circle ledTempo;
	@FXML
	private Circle ledMeasure;
	@FXML
	private Slider tempoSlider;
	@FXML
	private Label tempoSpeed;
	@FXML
	private Label measureSpeed;
	@FXML
	private AudioClip acTempo;
	@FXML
	private AudioClip acMeasure;
	@FXML
	private javafx.scene.control.Button closeButton;

	public Circle getLedTempo() {
		return this.ledTempo;
	}

	public Circle getLedMeasure() {
		return this.ledMeasure;
	}

	public Ihm() {
	}

	public SliderButton getCursor() {
		return this.cursor;
	}

	public Label getTempoLabel() {
		return this.tempoSpeed;
	}

	public Label getMeasureLabel() {
		return this.measureSpeed;
	}

	public AudioClip getAudioClipMesure() {
		return this.acMeasure;
	}

	public AudioClip getAudioClipTemps() {
		return this.acTempo;
	}

	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		this.controller = new Controller(this);

		this.start = new StartButton(new Start(this.controller));
		this.stop = new StopButton(new Stop(this.controller));
		this.incMeasure = new IncMeasureButton(new IncMeasure(this.controller));
		this.decMeasure = new DecMeasureButton(new DecMeasure(this.controller));

		this.cursor = new SliderButton(new UpdateCursor(this.controller));

		this.tempoSlider.setValue(this.controller.getEngine().getTempo());
		this.tempoSlider.setMin(this.controller.getEngine().getMinTempo());
		this.tempoSlider.setMax(this.controller.getEngine().getMaxTempo());

		this.tempoSpeed.setText(String.valueOf(this.controller.getEngine().getTempo()));
		this.measureSpeed.setText(String.valueOf(this.controller.getEngine().getMeasure()));

		this.acTempo = new AudioClip(Ihm.class.getResource(this.tempoSound).toString());
		this.acMeasure = new AudioClip(Ihm.class.getResource(this.measureSound).toString());

		this.tempoSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
			this.cursor.setPosition(newValue.intValue());
			this.cursor.getCommand().execute();
		});
	}

	/**
	 * @see command.Stop#execute()
	 */
	@FXML
	public void stop() {
		this.stop.getCommand().execute();
	}

	/**
	 * @see command.Start#execute()
	 */
	@FXML
	public void start() {
		this.start.getCommand().execute();
	}

	/**
	 * @see command.IncMeasure#execute()
	 */
	@FXML
	public void inc() {
		this.incMeasure.getCommand().execute();
	}

	/**
	 * @see command.DecMeasure#execute()
	 */
	@FXML
	public void dec() {
		this.decMeasure.getCommand().execute();
	}

	/**
	 * linked close button in view to closing page execution method
	 */
	@FXML
	private void closeButtonAction() {
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}

	/**
	 * light the measure led in the view 
	 */
	public void beatMeasure() {
		this.getLedTempo().setFill(Color.RED);
		try {
			sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.getLedTempo().setFill(Color.GREY);
		this.getAudioClipMesure().play();
	}

	/**
	 * light the tempo led in the view
	 */
	public void beatTempo() {
		this.getLedMeasure().setFill(Color.GREEN);
		try {
			sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.getLedMeasure().setFill(Color.GREY);
		this.getAudioClipTemps().play();
	}
}
