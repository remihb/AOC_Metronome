package engine;

import command.Command;

public interface IEngine {

    /**
     * @return min tempo value
     */
    int getMinTempo();
    
    /**
     * @return max tempo value
     */
    int getMaxTempo();
    
    /**
     * @return min measure value
     */
    int getMinMeasure();
    
    /**
     * @return max measure value
     */
    int getMaxMeasure();
    
    /**
     * @return engine activation state
     */
    boolean isActive();
    
    /**
     * @param active
     * activate the engine
     */
    void setActive(boolean active);
    
    /**
     * @return current tempo value
     */
    int getTempo();
    
    /**
     * @param tempo
     * set tempo value
     */
    void setTempo(int tempo);
    
    /**
     * @return current measure value
     */
    int getMeasure();
    
    /**
     * @param measure
     * set measure value
     */
    void setMeasure(int measure);
    
    /**
     * @param s
     * @param c
     * instanciate engine commands
     */
    void setCommands(String s, Command c);

}
