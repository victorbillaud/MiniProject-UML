package Model1;

import java.util.*;

/**
 * 
 */
public class UseMode {

    /**
     * Default constructor
     */
    public UseMode(String _mode) {
        this.Mode =  _mode;
    }

    /**
     * 
     */
    public String Mode;

    @Override
    public String toString() {
        return ConsoleColors.BLUE_BOLD + Mode + ConsoleColors.RESET;
    }
}