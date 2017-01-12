package controller;

/**
 * @author remihb
 * Controller interface for linking the engine and the ihm
 */
public interface IController {

    /**
     * start the engine and allow it to launch the timer
     */
    void start();
    
    /**
     * start the engine and allow it to launch the timer
     */
    void stop();
    
    /**
     * update the engine tempo value according to the tempo slider changes in the ihm
     */
    void updateCursor();
    
    /**
     * increment the measure counter of the engine
     */
    void incMeasure();
    
    /**
     * decrement the measure counter of the engine
     */
    void decMeasure();
    
    /**
     * light the ihm tempo led according to the timer cycle of the engine
     */
    void beatTempo();
    
    /**
     * light the ihm measure led according to the timer cycle of the engine
     */
    void beatMeasure();
   
    /**
     * update the ihm tempo label according to the tempo value of the engine
     */
    void updateTempo();
    
    /**
     * update the ihm measure label according to the measure value of the engine
     */
    void updateMeasure();
    
}
