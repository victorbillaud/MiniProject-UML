package Model1;

import java.util.*;

/**
 * 
 */
public class Supervisor {

    /**
     * Default constructor
     */
    public Supervisor(Integer _id, String _fullname) {
        this.ID = _id;
        this.Fullname = _fullname;
    }

    /**
     * 
     */
    public Integer ID;

    /**
     * 
     */
    public String Fullname;

    /**
     * 
     */
    public Building Building;

    /**
     * 
     */
    public GlobalMeter GlobalMeter;


    @Override
    public String toString() {
        return "SUPERVISOR "
                + ConsoleColors.GREEN_BOLD_BRIGHT + this.ID + ConsoleColors.RESET + " | "
                + ConsoleColors.PURPLE +  this.Fullname + ConsoleColors.RESET + " | "
                + ConsoleColors.WHITE + "building "  + this.Building.ID + ConsoleColors.RESET +  " | ";
    }
}